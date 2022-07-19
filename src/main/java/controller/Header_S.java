package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategorieDao;
import dao.Sous_categorieDao;
import dao.UtilisateurDao;

@WebServlet("/header")
public class Header_S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategorieDao categorieDao = new CategorieDao();
	Sous_categorieDao sousCategorieDao = new Sous_categorieDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Header_S() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		ArrayList listeCategories = new ArrayList<>();
		listeCategories = categorieDao.read();
		request.setAttribute("listeCategories", listeCategories);

		System.out.println(listeCategories.get(0));

		for (int i = 0; i < listeCategories.size(); i++) {
			ArrayList listeSousCategParCateg = new ArrayList<>();
			int id_categorie = listeCategories.get(i).getId_categorie();
			listeSousCategParCateg = sousCategorieDao.findByCat(id_categorie);
		}

		request.getRequestDispatcher("header.jsp").forward(request, response);

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
