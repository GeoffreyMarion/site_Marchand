package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommandeDao;
import dao.Details_commandeDao;
import dao.ProduitDao;
import dao.UtilisateurDao;
import model.Commande;
import model.Details_commande;
import model.Details_panier;
import model.Panier;
import model.Produit;

/**
 * Servlet implementation class Panier_S
 */
@WebServlet("/panier")
public class Panier_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProduitDao produitDao = new ProduitDao();
	UtilisateurDao uDao = new UtilisateurDao();
	Details_commandeDao DcDao = new Details_commandeDao();
	CommandeDao cDao = new CommandeDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Panier_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		Panier panier=(Panier) session.getAttribute("panier");
		System.out.println(panier);
		session.setAttribute( "panier", panier );
		boolean emptyCart = true;
		if(panier != null) {
			if(panier.count() >0) {
				emptyCart = false;
			}			
		}
		
		//AJOUTER AU PANIER
		if(request.getParameter("quantity")!=null ) {	
			int newQuantity =Integer.valueOf(request.getParameter("quantity"));
			int idProduit = Integer.valueOf(request.getParameter("idProduit"));
			Produit prod_temp=produitDao.findById(idProduit);
			Details_panier panierUpdated = new Details_panier(prod_temp,newQuantity);							
			Panier panier3=(Panier) session.getAttribute("panier");
			panier3.update(panierUpdated, newQuantity);
			session.setAttribute( "panier", panier3 );
		}
		
		//Valier Panier
		if(request.getParameter("valider")!=null) {
			System.out.println("valider");
			Panier panierv = (Panier)session.getAttribute("panier");
			Commande commande = new Commande();
			Float total= null;
			for (Details_panier details_panier : panierv.produits) {
				Produit prod = details_panier.getProduit();
				int quant = details_panier.getQte();
				Details_commande detail = new Details_commande(commande,prod,quant,prod.getPrix());
				total+=prod.getPrix()*quant;
				DcDao.create(detail);
			}
			commande.setUtilisateur(uDao.findById((int)session.getAttribute("id_user")));
			commande.setTotal(total);
			cDao.create(commande);
		}
		
//		SUPPRIMER UN PRODUIT => PANIER
		if(request.getParameter("idtodelete")!=null ) {
			int idproduit=Integer.valueOf(request.getParameter("idtodelete"));
			Panier panier2=(Panier) session.getAttribute("panier");
			panier2.delete(idproduit);
			if(panier.count() == 0) {
				emptyCart = true;
			}
			session.setAttribute( "panier", panier2 );
		}
		session.setAttribute("emptyCart", emptyCart);
		request.getRequestDispatcher("panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
