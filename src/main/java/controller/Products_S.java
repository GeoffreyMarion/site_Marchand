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
import dao.RechercheDao;
import dao.SlideDao;
import dao.Sous_categorieDao;
import model.Details_panier;
import model.Favori;
import model.Panier;
import model.Produit;
import model.Recherche;
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
    RechercheDao rDao = new RechercheDao();
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
			if(fDao.findByU_P(prod.getId_produit(),user.getId_utilisateur()).isEmpty()) {
				fDao.create(favori);
			}
		}
		if (request.getParameter("idSCat") != null) {
			int id = Integer.parseInt(request.getParameter("idSCat"));
			request.setAttribute("id",id);
			request.setAttribute("Sous_cat",s_cDao.findById(id));
			request.setAttribute("ListProduit",pDao.findBySCat(id));
			
			if(request.getParameter("padd")!=null ) {	
				int id_produit=Integer.valueOf(request.getParameter("padd"));
				Produit prod_temp=pDao.findById(id_produit);

				int qte=Integer.valueOf(request.getParameter("pqte"));
				Details_panier panieradd=new Details_panier(prod_temp,qte);	
				
				Panier panier=(Panier) session.getAttribute("panier");
				panier.ajouter(panieradd);
				session.setAttribute( "panier", panier );
			}
		}
		else if (request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("mot", mot);
			Utilisateur u = new Utilisateur();
			if(session.getAttribute("iduser") != null) {
				u.setId_utilisateur((int) session.getAttribute("iduser"));
			} else {
				u.setId_utilisateur((1));

			}
			Recherche r = new Recherche();
			r.setUtilisateur(u);
			r.setMot_cle(mot);
			if (!(mot.equals(""))) {
				rDao.create(r);
			}
			request.setAttribute("ListProduit", pDao.findByMot(mot));
		}
		else if (request.getParameter("idCat") != null) {
			int idc = Integer.parseInt(request.getParameter("idCat"));
			request.setAttribute("idc",idc);
			request.setAttribute("ListProduit",pDao.findByCat(idc));
		} else if(request.getParameter("id") != null) {
					response.sendRedirect(request.getContextPath()+"product?id="+request.getParameter("id"));
				}
		else {
			if(request.getParameter("padd")!=null ) {	
				int id_produit=Integer.valueOf(request.getParameter("padd"));
				Produit prod_temp=pDao.findById(id_produit);
				int qte=Integer.valueOf(request.getParameter("pqte"));
				Details_panier panieradd=new Details_panier(prod_temp,qte);	
				
				Panier panier=(Panier) session.getAttribute("panier");
				panier.ajouter(panieradd);
				session.setAttribute( "panier", panier );
			}
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
