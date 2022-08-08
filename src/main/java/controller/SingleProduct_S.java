package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentaireDao;
import dao.FavoriDao;
import dao.ProduitDao;
import dao.SlideDao;
import dao.Sous_categorieDao;
import model.Commentaire;
import model.Details_panier;
import model.Favori;
import model.Panier;
import model.Produit;
import model.Sous_categorie;
import model.Utilisateur;

/**
 * Servlet implementation class SingleProduct_S
 */
@WebServlet("/product")
public class SingleProduct_S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProduitDao produitDao = new ProduitDao();
	Sous_categorieDao sousCategorieDao = new Sous_categorieDao();
	CommentaireDao commentaireDao = new CommentaireDao();
    FavoriDao fDao = new FavoriDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SingleProduct_S() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		if (request.getParameter("fav") != null) {
			HttpSession session = request.getSession();

			Utilisateur user = new Utilisateur();
			user.setId_utilisateur((int)session.getAttribute("iduser"));
			Produit prod = new Produit();
			prod.setId_produit(Integer.parseInt(request.getParameter("fav")));
			Favori favori = new Favori(prod,user);
			if(fDao.findByU_P(prod.getId_produit(),user.getId_utilisateur()).isEmpty()) {
				fDao.create(favori);
			}
		}
		
		if (request.getParameter("id") != null) {
			int idAsInt = Integer.parseInt(request.getParameter("id"));
			System.out.println("idAsInt: " + idAsInt);

			Produit produit = produitDao.findById(idAsInt);

			Sous_categorie sousCategorieFromProduit = produit.getSous_categorie();
			int sousCategorieId = sousCategorieFromProduit.getId_sous_categorie();
			String sousCategorieTitre = sousCategorieFromProduit.getTitre();
			
			ArrayList<Produit> sousCategorieProduits = produitDao.findBySCat(sousCategorieId);
			ArrayList<Produit> sousCategorieProduitsApresFiltre = new ArrayList<Produit>();

			for(Produit produitOriginalList: sousCategorieProduits) {
				if(produitOriginalList.getId_produit() != idAsInt) {
					sousCategorieProduitsApresFiltre.add(produitOriginalList);
				}
			}
			
			ArrayList<Commentaire> commentairesFromProduit = commentaireDao.findByP(idAsInt);
			
			request.setAttribute("id",idAsInt);
			request.setAttribute("produit", produit);
			request.setAttribute("produitsSimilaires", sousCategorieProduitsApresFiltre);
			request.setAttribute("sousCategorieTitre", sousCategorieTitre);
			request.setAttribute("commentairesFromProduit", commentairesFromProduit);

			//AJOUTER AU PANIER
			if(request.getParameter("padd")!=null ) {	
				int id_produit=Integer.valueOf(request.getParameter("padd"));
				Produit prod_temp=produitDao.findById(id_produit);
				
				System.out.println("within padd");

				HttpSession session = request.getSession();
				System.out.println("session within padd" + session);

				int qte=Integer.valueOf(request.getParameter("pqte"));
				Details_panier panieradd=new Details_panier(prod_temp,qte);	
				
				Panier panier=(Panier) session.getAttribute("panier");
				panier.ajouter(panieradd);
				session.setAttribute( "panier", panier );
		
				System.out.println((Panier) session.getAttribute("panier"));
				System.out.println(session.getAttribute("panier").getClass().getSimpleName());
			}
		}
			
		request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
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
