package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Details_commandeDao;
import model.Adresse_livraison;
import model.Commande;
import model.Utilisateur;

/**
 * Servlet implementation class A_details_commande_S
 */
@WebServlet("/a_details_commande")
public class A_details_commande_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Details_commandeDao dcDao = new Details_commandeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_details_commande_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
		if (request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListDetails_commande", dcDao.findByMot(mot));
		} else {
			request.setAttribute("ListDetails_commande", dcDao.read());
		}
			request.getRequestDispatcher("a_details_commande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
