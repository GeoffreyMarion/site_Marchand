package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Entree_en_stockDao;
import dao.FournisseurDao;
import dao.ProduitDao;
import dao.Sous_categorieDao;
import model.Entree_en_stock;
import model.Fournisseur;
import model.Produit;

/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_entree_en_stock")
public class A_entree_en_stock_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Entree_en_stockDao eesDao = new Entree_en_stockDao();
      FournisseurDao fDao = new FournisseurDao();
      ProduitDao pDao = new ProduitDao();
      Sous_categorieDao scatDao = new Sous_categorieDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_entree_en_stock_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("s-sscat") != null) {
			int souscat = Integer.parseInt(request.getParameter("s-scat"));
			request.setAttribute("ListEntreeenstock", eesDao.findBySCat(souscat));
		}
		else if(request.getParameter("s-date") != null) {
			String date = request.getParameter("date");
			request.setAttribute("ListEntreeenstock", eesDao.findByD(date));
		}
		else if(request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListEntreeenstock", eesDao.FindByMot(mot));
		}
		else {request.setAttribute("ListEntreeenstock", eesDao.read());}
		
		request.setAttribute("ListSCat", scatDao.read());
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;
		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Entree_en_stock eestock = eesDao.findById(edit);
			request.setAttribute("edit", edit);
			request.setAttribute("eestock", eestock);
			if (request.getParameter("c-edit") != null) {
				int idfournisseur = Integer.parseInt(request.getParameter("e-idfournisseur"));
				Fournisseur fournisseur = fDao.findById(idfournisseur);
				int idproduit = Integer.parseInt(request.getParameter("e-idproduit"));
				Produit produit = pDao.findById(idproduit);
				int quantite = Integer.parseInt(request.getParameter("e-quantite"));
				eesDao.update(fournisseur, produit, quantite, edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_entree_en_stock?edition=true");
			}else {
			request.getRequestDispatcher("a_entree_en_stock.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);
			if (request.getParameter("c-create") != null) {
				int idfournisseur = Integer.parseInt(request.getParameter("idfournisseur"));
				Fournisseur fournisseur = fDao.findById(idfournisseur);
				int idproduit = Integer.parseInt(request.getParameter("idproduit"));
				Produit produit = pDao.findById(idproduit);
				int quantite = Integer.parseInt(request.getParameter("quantite"));
				Entree_en_stock eestock = new Entree_en_stock(fournisseur, produit, quantite);
			eesDao.create(eestock);
			pDao.updateS(produit.getStock()+quantite, idproduit);
			creation = true;
			request.setAttribute("creation", creation);
			response.sendRedirect("a_entree_en_stock?creation=true");
			}
			else {
			request.getRequestDispatcher("a_entree_en_stock.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("suppr") != null) {
		int suppr = Integer.parseInt(request.getParameter("suppr"));
		eesDao.remove(suppr);
		suppression = true;
		request.setAttribute("suppression", suppression);
		request.setAttribute("ListEntreeenstock", eesDao.read());
		response.sendRedirect("a_entree_en_stock?suppression=true");
		}
		else{request.getRequestDispatcher("a_entree_en_stock.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

