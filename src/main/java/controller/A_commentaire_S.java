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
import model.Categorie;
import model.Commentaire;
import model.Produit;
import model.Utilisateur;

/**
 * Servlet implementation class A_commentaire_S
 */
@WebServlet("/a_commentaire")
public class A_commentaire_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CommentaireDao cDao = new CommentaireDao();
       ProduitDao pDao = new ProduitDao();
       UtilisateurDao uDao = new UtilisateurDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_commentaire_S() {
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
			request.setAttribute("ListComm", cDao.FindByMot(mot));
		}
		else {request.setAttribute("ListComm", cDao.read());}
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;

		if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);

			if (request.getParameter("c-create") != null) {
				String comm = request.getParameter("comm");
				int note = Integer.parseInt(request.getParameter("note"));
				int id_produit = Integer.parseInt(request.getParameter("id_produit"));
				Produit produit = pDao.findById(id_produit);
				int id_utilisateur = Integer.parseInt(request.getParameter("id_utilisateur"));
				Utilisateur utilisateur = uDao.findById(id_utilisateur);
				Commentaire commentaire = new Commentaire(comm,note,produit,utilisateur);
				cDao.create(commentaire);
				creation = true;
				request.setAttribute("creation", creation);
				response.sendRedirect("a_commentaire?creation=true");
			} else {
				request.getRequestDispatcher("a_commentaire.jsp").forward(request, response);
			}
		} else if (request.getParameter("suppr") != null) {
			int suppr = Integer.parseInt(request.getParameter("suppr"));
			cDao.remove(suppr);
			suppression = true;
			request.setAttribute("suppression", suppression);
			request.setAttribute("ListComm", cDao.read());
			response.sendRedirect("a_commentaire?suppression=true");
		} else {
			request.getRequestDispatcher("a_commentaire.jsp").forward(request, response);
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
