package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FavoriDao;
import dao.ProduitDao;
import dao.SlideDao;
import dao.Sous_categorieDao;
import model.Favori;
import model.Produit;
import model.Utilisateur;

/**
 * Servlet implementation class Products
 */
@WebServlet("/products")
public class Products_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProduitDao pDao = new ProduitDao();
    Sous_categorieDao s_cDao= new Sous_categorieDao();
    SlideDao slideDao = new SlideDao();
    FavoriDao fDao = new FavoriDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("ListSlide", slideDao.read());
		
		if (request.getParameter("fav") != null) {
			Utilisateur user = new Utilisateur();
			user.setId_utilisateur((int)session.getAttribute("iduser"));
			Produit prod = new Produit();
			prod.setId_produit(Integer.parseInt(request.getParameter("fav")));
			Favori favori = new Favori(prod,user);
			fDao.create(favori);
			System.out.println("favori");
		}
		if (request.getParameter("idSCat") != null) {
			int id = Integer.parseInt(request.getParameter("idSCat"));
			request.setAttribute("id",id);
			request.setAttribute("Sous_cat",s_cDao.findById(id));
			request.setAttribute("ListProduit",pDao.findBySCat(id));
		}
		else if (request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("mot",mot);
			request.setAttribute("ListProduit",pDao.findByMot(mot));
		}
		else if (request.getParameter("idCat") != null) {
			int idc = Integer.parseInt(request.getParameter("idCat"));
			request.setAttribute("idc",idc);
			request.setAttribute("ListProduit",pDao.findByCat(idc));
		} else if(request.getParameter("id") != null) {
					response.sendRedirect(request.getContextPath()+"product?id="+request.getParameter("id"));
				}
		else {
			request.setAttribute("ListProduit", pDao.read());
		}
			request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
