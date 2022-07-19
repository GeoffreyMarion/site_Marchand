package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDao;
import model.Utilisateur;

/**
 * Servlet implementation class Utilisateur_S
 */
@WebServlet("/login")
public class Login_S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UtilisateurDao utilisateurDao = new UtilisateurDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login_S() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean messageinscriptionok = false;
		if (request.getParameter("register") != null) {
			request.setAttribute("nom", request.getParameter("nom"));
			request.setAttribute("prenom", request.getParameter("prenom"));
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("password", request.getParameter("password"));
			request.setAttribute("cpassword", request.getParameter("cpassword"));

			Utilisateur utilisateur = new Utilisateur(request.getParameter("nom"), request.getParameter("prenom"), null,
					request.getParameter("email"), request.getParameter("password"));
			messageinscriptionok = utilisateurDao.create(utilisateur);
		}
		request.setAttribute("messageinscriptionok", messageinscriptionok);

		boolean connected = false;
		boolean messageconnexionno = false;
		if (request.getParameter("connect") != null) {
			String email = request.getParameter("email_l");
			String mdp = request.getParameter("password_l");
			String cmdp = request.getParameter("cpassword_l");
			Utilisateur utilisateur = utilisateurDao.connexion(email, mdp, cmdp);

			if (utilisateur == null) {
				messageconnexionno = true;
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("iduser", utilisateur.getId_utilisateur());
				session.setAttribute("nomuser", utilisateur.getNom());
				session.setAttribute("prenomuser", utilisateur.getPrenom());
				session.setAttribute("dateuser", utilisateur.getDate_inscription());
				connected = true;
				response.sendRedirect("index");
			}

		}
		request.setAttribute("messageconnexionno", messageconnexionno);

		if (connected == false) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
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
