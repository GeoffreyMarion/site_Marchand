package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FournisseurDao;
import model.Fournisseur;

/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_fournisseur")
public class A_fournisseur_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
      FournisseurDao fDao = new FournisseurDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_fournisseur_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListFournisseur", fDao.FindByMot(mot));
		}
		else {request.setAttribute("ListFournisseur", fDao.read());}
		
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;
		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Fournisseur four = fDao.findById(edit);
			request.setAttribute("edit", edit);
			request.setAttribute("four", four);
			if (request.getParameter("c-edit") != null) {
				String nom = request.getParameter("e-nom");
				fDao.update(nom, edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_fournisseur?edition=true");
			}else {
			request.getRequestDispatcher("a_fournisseur.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);
			if (request.getParameter("c-create") != null) {
				String nom = request.getParameter("nom");
				Fournisseur fournisseur = new Fournisseur(nom);
			fDao.create(fournisseur);
			creation = true;
			request.setAttribute("creation", creation);
			response.sendRedirect("a_fournisseur?creation=true");
			}
			else {
			request.getRequestDispatcher("a_fournisseur.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("suppr") != null) {
		int suppr = Integer.parseInt(request.getParameter("suppr"));
		fDao.remove(suppr);
		suppression = true;
		request.setAttribute("suppression", suppression);
		request.setAttribute("ListFournisseur", fDao.read());
		response.sendRedirect("a_fournisseur?suppression=true");
		}
		else{request.getRequestDispatcher("a_fournisseur.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


