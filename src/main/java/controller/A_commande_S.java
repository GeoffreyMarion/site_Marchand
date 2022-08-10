package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Adresse_livraisonDao;
import dao.CommandeDao;
import dao.UtilisateurDao;
import model.Adresse_livraison;
import model.Commande;
import model.Produit;
import model.Sous_categorie;
import model.Utilisateur;

/**
 * Servlet implementation class A_commande_S
 */
@WebServlet("/a_commande")
public class A_commande_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CommandeDao cDao= new CommandeDao();
       UtilisateurDao uDao = new UtilisateurDao();
       Adresse_livraisonDao aDao = new Adresse_livraisonDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_commande_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("s-date") != null) {
			String date = request.getParameter("date");
			request.setAttribute("ListCommande", cDao.findByD(date));
		}
		else if (request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListCommande", cDao.findByMot(mot));
		} else {
			request.setAttribute("ListCommande", cDao.read());
		}
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;

		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Commande comm = cDao.findById(edit);
			int id_ut = comm.getUtilisateur().getId_utilisateur();
			request.setAttribute("ListAdresse", aDao.findByIdU(id_ut));
			request.setAttribute("edit", edit);
			request.setAttribute("comm", comm);

			if (request.getParameter("c-edit") != null) {
				int id_user = comm.getUtilisateur().getId_utilisateur();
				Float total = comm.getTotal();
				int id_adresse = Integer.parseInt(request.getParameter("e-adresse"));
				int etat = Integer.parseInt(request.getParameter("e-etat"));
				Utilisateur user = uDao.findById(id_user);
				Adresse_livraison adresse = aDao.findById(id_adresse);
				cDao.update(user, total, adresse, etat,edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_commande?edition=true");
			} else {
				request.getRequestDispatcher("a_commande.jsp").forward(request, response);
			}
		} else if (request.getParameter("suppr") != null) {
			int suppr = Integer.parseInt(request.getParameter("suppr"));
			cDao.remove(suppr);
			suppression = true;
			request.setAttribute("suppression", suppression);
			request.setAttribute("ListProduit", cDao.read());
			response.sendRedirect("a_commande?suppression=true");
		} else {
			request.getRequestDispatcher("a_commande.jsp").forward(request, response);
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
