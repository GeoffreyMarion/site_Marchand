package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProduitDao;
import dao.Sous_categorieDao;
import model.Produit;
import model.Sous_categorie;

/**
 * Servlet implementation class SingleProduct_S
 */
@WebServlet("/product")
public class SingleProduct_S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProduitDao produitDao = new ProduitDao();
	Sous_categorieDao sousCategorieDao = new Sous_categorieDao();

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
		if (request.getParameter("id") != null) {
			int idAsInt = Integer.parseInt(request.getParameter("id"));
			Produit produit = produitDao.findById(idAsInt);

			Sous_categorie sousCategorieFromProduit = produit.getSous_categorie();
			int sousCategorieId = sousCategorieFromProduit.getId_sous_categorie();
			String sousCategorieTitre = sousCategorieFromProduit.getTitre();
			
			ArrayList<Produit> sousCategorieProduits = produitDao.findBySCat(sousCategorieId);
//			System.out.println("sousCategorieProduits before: " + sousCategorieProduits); 
//			System.out.println("produit.id_produit: " + produit.getId_produit()); 

			ArrayList<Produit> sousCategorieProduitsApresFiltre = new ArrayList<Produit>();

			for(Produit produitOriginalList: sousCategorieProduits) {
				if(produitOriginalList.getId_produit() != idAsInt) {
					sousCategorieProduitsApresFiltre.add(produitOriginalList);
				}
			}
//			System.out.println("sousCategorieProduitsApresFiltre: " + sousCategorieProduitsApresFiltre); 
			request.setAttribute("id",idAsInt);
			request.setAttribute("produit", produit);
			request.setAttribute("produitsSimilaires", sousCategorieProduitsApresFiltre);
			request.setAttribute("sousCategorieTitre", sousCategorieTitre);
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
