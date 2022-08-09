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
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_utilisateur")
public class A_utilisateur_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
      UtilisateurDao uDao = new UtilisateurDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_utilisateur_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("ListUtilisateur", uDao.read());
		
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;
		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Utilisateur user = uDao.findById(edit);
			request.setAttribute("edit", edit);
			request.setAttribute("user", user);
			String nom = request.getParameter("e-nom");
			String prenom = request.getParameter("e-prenom");
			String email = request.getParameter("e-email");
			String password = request.getParameter("e-pass");
			if (request.getParameter("c-edit") != null) {
				uDao.update(nom, prenom, email, password, edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_utilisateur?edition=true");
			}else {
			request.getRequestDispatcher("a_utilisateur.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String password = "1111";
			Utilisateur user = new Utilisateur(nom, prenom, email, password);
			if (request.getParameter("c-create") != null) {
			uDao.create(user);
			creation = true;
			request.setAttribute("creation", creation);
			response.sendRedirect("a_utilisateur?creation=true");
			}
			else {
			request.getRequestDispatcher("a_utilisateur.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("suppr") != null) {
		int suppr = Integer.parseInt(request.getParameter("suppr"));
		uDao.remove(suppr);
		suppression = true;
		request.setAttribute("suppression", suppression);
		request.setAttribute("ListUtilisateur", uDao.read());
		response.sendRedirect("a_utilisateur?suppression=true");
		}
		else{request.getRequestDispatcher("a_utilisateur.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

