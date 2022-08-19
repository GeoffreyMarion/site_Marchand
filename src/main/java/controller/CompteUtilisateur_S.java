package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Adresse_livraisonDao;
import dao.UtilisateurDao;
import model.Adresse_livraison;
import model.Favori;
import model.Produit;
import model.Utilisateur;

/**
 * Servlet implementation class Utilisateur_S
 */
@WebServlet("/compteutilisateur")
public class CompteUtilisateur_S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UtilisateurDao uDao = new UtilisateurDao();
	Adresse_livraisonDao aDao = new Adresse_livraisonDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteUtilisateur_S() {
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
		Utilisateur user = uDao.findById((int)session.getAttribute("iduser"));
		String uemail=user.getEmail();
		request.setAttribute("uemail", uemail);
		ArrayList<Adresse_livraison> Listadresses = aDao.findByIdU((int)session.getAttribute("iduser"));
		request.setAttribute("ListAdresses", Listadresses);
		
		if (request.getParameter("suppr") != null) {
			int suppr = Integer.parseInt(request.getParameter("suppr"));
			aDao.remove(suppr);
			ArrayList<Adresse_livraison> Listadressesup = aDao.findByIdU((int)session.getAttribute("iduser"));
			request.setAttribute("ListAdresses", Listadressesup);
			response.sendRedirect("compteutilisateur");
		}
		else if (request.getParameter("edit") != null) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String cpassword = request.getParameter("cpassword");
			
			if(password.equalsIgnoreCase(cpassword)) {
			uDao.update(nom, prenom, email, uemail, (int)session.getAttribute("iduser"));
			session.setAttribute("nomuser", nom);
			session.setAttribute("prenomuser", prenom);
			}
			response.sendRedirect("compteutilisateur");
		}
		
		else if (request.getParameter("add") != null) {
			String adresse = request.getParameter("adresse");
			int codepostal = Integer.parseInt(request.getParameter("codepostal"));
			String ville = request.getParameter("ville");
			String pays = request.getParameter("pays");
			Adresse_livraison adressel = new Adresse_livraison(user,adresse, codepostal, ville, pays);
			aDao.create(adressel);
			ArrayList<Adresse_livraison> Listadressesup = aDao.findByIdU((int)session.getAttribute("iduser"));
			request.setAttribute("ListAdresses", Listadressesup);
			response.sendRedirect("compteutilisateur");
		}
		
		else {
		request.getRequestDispatcher("compteUtilisateur.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
