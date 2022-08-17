package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdministrateurDao;
import model.Administrateur;

/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_administrateur")
public class A_administrateur_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
      AdministrateurDao aDao = new AdministrateurDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_administrateur_S() {
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
			request.setAttribute("ListAdministrateur", aDao.FindByMot(mot));
		}
		else {request.setAttribute("ListAdministrateur", aDao.read());}
		
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;
		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Administrateur administrateur = aDao.findById(edit);
			request.setAttribute("edit", edit);
			request.setAttribute("administrateur", administrateur);
			if (request.getParameter("c-edit") != null) {
				String nom = request.getParameter("e-nom");
				String email = request.getParameter("e-email");
				String mot_de_passe = request.getParameter("e-mot_de_passe");
				String privileges = request.getParameter("e-privileges");
				aDao.update(nom,email,mot_de_passe,privileges,edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_administrateur?edition=true");
			}else {
			request.getRequestDispatcher("a_administrateur.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);
			if (request.getParameter("c-create") != null) {
				String nom = request.getParameter("nom");
				String email = request.getParameter("email");
				String mot_de_passe = request.getParameter("mot_de_passe");
				String privileges = request.getParameter("privileges");
				Administrateur administrateur = new Administrateur(nom,email,mot_de_passe,privileges);
				aDao.create(administrateur);
			creation = true;
			request.setAttribute("creation", creation);
			response.sendRedirect("a_administrateur?creation=true");
			}
			else {
			request.getRequestDispatcher("a_administrateur.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("suppr") != null) {
		int suppr = Integer.parseInt(request.getParameter("suppr"));
		aDao.remove(suppr);
		suppression = true;
		request.setAttribute("suppression", suppression);
		request.setAttribute("ListAdministrateur", aDao.read());
		response.sendRedirect("a_administrateur?suppression=true");
		}
		else{request.getRequestDispatcher("a_administrateur.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


