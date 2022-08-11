package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategorieDao;
import dao.Sous_categorieDao;
import model.Categorie;
import model.Produit;
import model.Sous_categorie;

/**
 * Servlet implementation class A_sous_categorie_S
 */
@WebServlet("/a_sous_categorie")
public class A_sous_categorie_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Sous_categorieDao scDao = new Sous_categorieDao();
       CategorieDao cDao = new CategorieDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_sous_categorie_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		request.setAttribute("ListCat", cDao.read());

		if(request.getParameter("se-cat") != null) {
			int cat = Integer.parseInt(request.getParameter("s-cat"));
			request.setAttribute("ListSCat", scDao.findByCat(cat));
		}
		else if(request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListSCat", scDao.FindByMot(mot));
		}
		else {request.setAttribute("ListSCat", scDao.read());}
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;

		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Sous_categorie sous_categorie = scDao.findById(edit);
			
			request.setAttribute("edit", edit);
			request.setAttribute("sous_categorie", sous_categorie);

			if (request.getParameter("c-edit") != null) {
				String titre = request.getParameter("e-titre");
				int cat = Integer.parseInt(request.getParameter("e-cat"));
				Categorie categorie = cDao.findById(cat);
				scDao.update(titre, categorie,edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_sous_categorie?edition=true");
			} else {
				request.getRequestDispatcher("a_sous_categorie.jsp").forward(request, response);
			}
		} else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);

			if (request.getParameter("c-create") != null) {
				String titre = request.getParameter("titre");
				int cat = Integer.parseInt(request.getParameter("cat"));
				Categorie categorie = cDao.findById(cat);
				Sous_categorie sous_categorie = new Sous_categorie(titre,categorie);
				scDao.create(sous_categorie);
				creation = true;
				request.setAttribute("creation", creation);
				response.sendRedirect("a_sous_categorie?creation=true");
			} else {
				request.getRequestDispatcher("a_sous_categorie.jsp").forward(request, response);
			}
		} else if (request.getParameter("suppr") != null) {
			int suppr = Integer.parseInt(request.getParameter("suppr"));
			scDao.remove(suppr);
			suppression = true;
			request.setAttribute("suppression", suppression);
			request.setAttribute("ListSCat", scDao.read());
			response.sendRedirect("a_sous_categorie?suppression=true");
		} else {
			request.getRequestDispatcher("a_sous_categorie.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
