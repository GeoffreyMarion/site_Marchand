package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ImagesDao;
import dao.ProduitDao;
import dao.RechercheDao;
import dao.Sous_categorieDao;
import dao.UtilisateurDao;
import model.Images;
import model.Produit;
import model.Recherche;
import model.Sous_categorie;
import model.Utilisateur;

/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_produit")
public class A_produit_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitDao pDao = new ProduitDao();
	Sous_categorieDao sCatDao = new Sous_categorieDao();
	RechercheDao rDao = new RechercheDao();
	UtilisateurDao uDao = new UtilisateurDao();
	ImagesDao iDao = new ImagesDao();

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
		
		request.setAttribute("ListImages", iDao.read());
		
		if(request.getParameter("s-sscat") != null) {
			int souscat = Integer.parseInt(request.getParameter("s-scat"));
			request.setAttribute("ListProduit", pDao.findBySCat(souscat));
		}
		else if(request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			if(request.getParameter("iduser")!=null) {
			Utilisateur u = uDao.findById(Integer.parseInt(request.getParameter("iduser")));
			Recherche recherche = new Recherche(u,mot);
			rDao.create(recherche);}
			else { Utilisateur u = uDao.findById(1); 
			Recherche recherche = new Recherche(u,mot);
			rDao.create(recherche);}
			request.setAttribute("ListProduit", pDao.findByMot(mot));
		}
		else {request.setAttribute("ListProduit", pDao.read());}
		request.setAttribute("ListSCat", sCatDao.read());
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;

		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Produit prod = pDao.findById(edit);
			request.setAttribute("edit", edit);
			request.setAttribute("prod", prod);
			ArrayList<Images> Images = iDao.findByProd(edit);
			request.setAttribute("ListImagesprod", Images);

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
				String image2 = request.getParameter("e-image2");
				iDao.update(prod,image2,Images.get(0).getId_image());
				String image3 = request.getParameter("e-image3");
				iDao.update(prod,image3,Images.get(1).getId_image());
				String image4 = request.getParameter("e-image4");
				iDao.update(prod,image4,Images.get(2).getId_image());
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
				String image2 = request.getParameter("image2");
				Images images2 = new Images(prod,image2);
				iDao.create(images2);
				String image3 = request.getParameter("image3");
				Images images3 = new Images(prod,image3);
				iDao.create(images3);
				String image4 = request.getParameter("image4");
				Images images4 = new Images(prod,image4);
				iDao.create(images4);
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
