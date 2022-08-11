package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RechercheDao;


/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_recherche")
public class A_recherche_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RechercheDao rDao = new RechercheDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public A_recherche_S() {
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
		
		if(request.getParameter("s-date") != null) {
			String date = request.getParameter("date");
			request.setAttribute("ListRecherche", rDao.findByD(date));
		}		
		else if(request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListRecherche", rDao.FindByMot(mot));
		}
		else {request.setAttribute("ListRecherche", rDao.read());}
			request.getRequestDispatcher("a_recherche.jsp").forward(request, response);
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

