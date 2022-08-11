package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentaireDao;
import dao.ProduitDao;
import dao.UtilisateurDao;
import model.Commentaire;
import model.Contact;
import model.Produit;
import model.Utilisateur;

/**
 * Servlet implementation class Commentaire_S
 */
@WebServlet("/commentaire")
public class Commentaire_S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	ProduitDao produitDao = new ProduitDao();
	CommentaireDao commentaireDao = new CommentaireDao();
	UtilisateurDao utilisateurDao = new UtilisateurDao();

	public Commentaire_S() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();

		int id_produit = Integer.valueOf(request.getParameter("id"));
		System.out.println("id_produit:" + id_produit);

		Produit currentProduct = produitDao.findById(id_produit);
		System.out.println("produit:" + currentProduct);

		request.setAttribute("produit", currentProduct);

		int idCurrentUser = (int) session.getAttribute("iduser");

		if (request.getParameter("send") != null) {
			String contentCommentaire = request.getParameter("contentCommentaire");
			int note = Integer.valueOf(request.getParameter("note"));
			System.out.println("contentCommentaire:" + contentCommentaire);
			System.out.println("note:" + note);

			Commentaire newCommentaire = new Commentaire();
			boolean contentCommentaireOK;

			if (contentCommentaire.equals("")) {
				contentCommentaireOK = false;
				request.setAttribute("contentCommentaireOK", contentCommentaireOK);
				request.getRequestDispatcher("commentaire.jsp").forward(request, response);
			} else {
				contentCommentaireOK = true;
				Utilisateur currentUser = utilisateurDao.findById(idCurrentUser);
				newCommentaire.setCommentaire(contentCommentaire);
				newCommentaire.setUtilisateur(currentUser);
				newCommentaire.setProduit(currentProduct);
				newCommentaire.setNote(note);
				
				System.out.println("newCommentaire:" + newCommentaire);

				commentaireDao.create(newCommentaire);
				request.setAttribute("contentCommentaireOK",contentCommentaireOK );
				response.sendRedirect("index");
			}
		} else {
			request.getRequestDispatcher("commentaire.jsp").forward(request, response);
		}
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
