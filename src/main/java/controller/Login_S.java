package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDao;


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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("listeUtilisateurs", utilisateurDao.read());
		
if (request.getParameter("id") != null && request.getParameter("action").equalsIgnoreCase("edit")) {
			
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

