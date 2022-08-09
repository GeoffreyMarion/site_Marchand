package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProduitDao;
import dao.Sous_categorieDao;
import model.Produit;
import model.Sous_categorie;

/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_produit")
public class A_produit_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitDao pDao = new ProduitDao();
	Sous_categorieDao sCatDao = new Sous_categorieDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public A_produit_S() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("ListProduit", pDao.read());
		request.setAttribute("ListSCat", sCatDao.read());
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;

		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Produit prod = pDao.findById(edit);
			
			request.setAttribute("edit", edit);
			request.setAttribute("prod", prod);

			if (request.getParameter("c-edit") != null) {
				String titre = request.getParameter("e-image");
				String description = request.getParameter("e-description");
				Float prix = Float.parseFloat(request.getParameter("e-prix"));
				String image = request.getParameter("e-image");
				int scat = Integer.parseInt(request.getParameter("e-scat"));
				int stock = Integer.parseInt(request.getParameter("e-stock"));
				int stockmin = Integer.parseInt(request.getParameter("e-stockmin"));
				Sous_categorie ssCat = sCatDao.findById(scat);
				pDao.update(titre, description, prix, image, ssCat, stock, stockmin, edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_produit?edition=true");
			} else {
				request.getRequestDispatcher("a_produit.jsp").forward(request, response);
			}
		} else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);

			if (request.getParameter("c-create") != null) {
				String titre = request.getParameter("titre");
				String description = request.getParameter("description");
				Float prix = Float.parseFloat(request.getParameter("prix"));
				String image = request.getParameter("image");
				int scat = Integer.parseInt(request.getParameter("scat"));
				int stock = Integer.parseInt(request.getParameter("stock"));
				int stockmin = Integer.parseInt(request.getParameter("stockmin"));
				Sous_categorie ssCat = sCatDao.findById(scat);
				Produit prod = new Produit(titre, description, prix, image, ssCat, stock, stockmin);
				pDao.create(prod);
				creation = true;
				request.setAttribute("creation", creation);
				response.sendRedirect("a_produit?creation=true");
			} else {
				request.getRequestDispatcher("a_produit.jsp").forward(request, response);
			}
		} else if (request.getParameter("suppr") != null) {
			int suppr = Integer.parseInt(request.getParameter("suppr"));
			pDao.remove(suppr);
			suppression = true;
			request.setAttribute("suppression", suppression);
			request.setAttribute("ListProduit", pDao.read());
			response.sendRedirect("a_produit?suppression=true");
		} else {
			request.getRequestDispatcher("a_produit.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
