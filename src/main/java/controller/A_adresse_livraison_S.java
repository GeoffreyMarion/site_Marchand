package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Adresse_livraisonDao;

/**
 * Servlet implementation class A_adresse_livraison_S
 */
@WebServlet("/a_adresse_livraison")
public class A_adresse_livraison_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Adresse_livraisonDao aDao = new Adresse_livraisonDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_adresse_livraison_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
				
		if(request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListAdresse", aDao.FindByMot(mot));
		}
		else {request.setAttribute("ListAdresse", aDao.read());}
			request.getRequestDispatcher("a_adresse_livraison.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
