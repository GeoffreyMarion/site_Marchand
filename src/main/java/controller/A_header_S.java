package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategorieDao;
import dao.Sous_categorieDao;

@WebServlet("/a_header")
public class A_header_S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategorieDao categorieDao = new CategorieDao();
	Sous_categorieDao sousCategorieDao = new Sous_categorieDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public A_header_S() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		HttpSession session = request.getSession( true );
//		if(session.getAttribute("isConnected")==null) {
//			session.setAttribute( "isConnected", false );
//		}
//
//		ArrayList listeCategories = new ArrayList<>();
//		listeCategories = categorieDao.read();
//		request.setAttribute("listeCategories", listeCategories);
//		
//		ArrayList listeSousCateg = new ArrayList<>();
//		listeSousCateg = sousCategorieDao.read();
//		request.setAttribute("listeSousCateg", listeSousCateg);
		
		request.getRequestDispatcher("a_header.jsp").include(request, response);
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
