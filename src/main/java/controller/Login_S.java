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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = new Utilisateur(request.getParameter("nom"),request.getParameter("prenom"),null, request.getParameter("email"),request.getParameter("password"));
		HttpSession session = request.getSession();
		session.setAttribute("utilisateur", utilisateur);
		
		
if (request.getParameter("id") != null && request.getParameter("action").equalsIgnoreCase("connect")) {
			
			request.setAttribute("showUtilisateur", utilisateurDao.findById(Integer.parseInt(request.getParameter("id"))));
		}
		if (request.getParameter("id") != null && request.getParameter("action").equalsIgnoreCase("delete")) {
			
			utilisateurDao.remove(Integer.parseInt(request.getParameter("id")));			
			response.sendRedirect(request.getContextPath()+"/utilisateurs");
		}else {
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("register")!=null) {
		request.setAttribute("nom", request.getParameter("nom"));
		request.setAttribute("prenom", request.getParameter("prenom"));
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("password", request.getParameter("password"));
		request.setAttribute("cpassword", request.getParameter("cpassword"));
		
		Utilisateur utilisateur = new Utilisateur(request.getParameter("nom"), request.getParameter("prenom"), null,
				request.getParameter("email"), request.getParameter("password"));
		utilisateurDao.create(utilisateur);
		utilisateur = utilisateurDao.findByEmail(request.getParameter("email"));
		session.setAttribute("utilisateur", utilisateur);
		}
		
		if(request.getParameter("connect")!=null) {
		request.setAttribute("email_l", request.getParameter("email_l"));
		request.setAttribute("password_l", request.getParameter("password_l"));
		request.setAttribute("cpassword_l", request.getParameter("cpassword_l"));
		
		Utilisateur utilisateur = utilisateurDao.findByEmail(request.getParameter("email_l"));
		session.setAttribute("utilisateur", utilisateur);
		}

		doGet(request, response);
	}

}

