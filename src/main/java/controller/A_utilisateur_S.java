package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDao;
import model.Favori;
import model.Produit;
import model.Recherche;
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
		if (request.getParameter("edit") != null) {
		int edit = Integer.parseInt(request.getParameter("edit"));
		Utilisateur user =uDao.findById(edit);
		request.setAttribute("edit",edit);
		request.setAttribute("user",user);
		}
		if (request.getParameter("create") != null) {
		int create = Integer.parseInt(request.getParameter("create"));
		request.setAttribute("create",create);
		}
		if (request.getParameter("suppr") != null) {
		int suppr = Integer.parseInt(request.getParameter("suppr"));
		uDao.remove(suppr);
		}
		request.getRequestDispatcher("a_utilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
