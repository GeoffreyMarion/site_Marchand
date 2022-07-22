package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategorieDao;
import dao.CoordonneesDao;

/**
 * Servlet implementation class Footer_S
 */
@WebServlet("/footer")
public class Footer_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	CoordonneesDao coordonneesDao = new CoordonneesDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Footer_S() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList coordonneesAsArray = new ArrayList<>();
		coordonneesAsArray = coordonneesDao.read();
		System.out.println(coordonneesDao.read().get(0));
		System.out.println(coordonneesDao.read().get(0).getNom());
		System.out.println(coordonneesDao.read().get(0).getAdresse());
		System.out.println(coordonneesDao.read().get(0).getLogo());
		
		String coordonneesNom = (String) coordonneesDao.read().get(0).getNom();
		String coordonneesEmail = (String) coordonneesDao.read().get(0).getEmail();
		String coordonneesAdresse = (String) coordonneesDao.read().get(0).getAdresse();
		String coordonneesLogo = (String) coordonneesDao.read().get(0).getLogo();
		String coordonneesTelephone = (String) coordonneesDao.read().get(0).getTelephone();

		request.setAttribute("coordonneesNom", coordonneesNom);
		request.setAttribute("coordonneesEmail", coordonneesEmail);
		request.setAttribute("coordonneesAdresse", coordonneesAdresse);
		request.setAttribute("coordonneesLogo", coordonneesLogo);
		request.setAttribute("coordonneesTelephone", coordonneesTelephone);

		request.getRequestDispatcher("footer.jsp").forward(request, response);

//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
