package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoordonneesDao;
import model.Coordonnees;

/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_coordonnees")
public class A_coordonnees_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
      CoordonneesDao cDao = new CoordonneesDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_coordonnees_S() {
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
			request.setAttribute("ListCoordonnees", cDao.FindByMot(mot));
		}
		else {request.setAttribute("ListCoordonnees", cDao.read());}
		
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;
		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Coordonnees coor = cDao.findById(edit);
			request.setAttribute("edit", edit);
			request.setAttribute("coor", coor);
			if (request.getParameter("c-edit") != null) {
				String nom = request.getParameter("e-nom");
				String adresse = request.getParameter("e-adresse");
				String telephone = request.getParameter("e-telephone");
				String email = request.getParameter("e-email");
				String logo = request.getParameter("e-logo");
				cDao.update(nom,adresse,telephone,email,logo,edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_coordonnees?edition=true");
			}else {
			request.getRequestDispatcher("a_coordonnees.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);
			if (request.getParameter("c-create") != null) {
				String nom = request.getParameter("nom");
				String adresse = request.getParameter("adresse");
				String telephone = request.getParameter("telephone");
				String email = request.getParameter("email");
				String logo = request.getParameter("logo");
				Coordonnees coor = new Coordonnees(nom,adresse,telephone,email,logo);
			cDao.create(coor);
			creation = true;
			request.setAttribute("creation", creation);
			response.sendRedirect("a_coordonnees?creation=true");
			}
			else {
			request.getRequestDispatcher("a_coordonnees.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("suppr") != null) {
		int suppr = Integer.parseInt(request.getParameter("suppr"));
		cDao.remove(suppr);
		suppression = true;
		request.setAttribute("suppression", suppression);
		request.setAttribute("ListCoordonnees", cDao.read());
		response.sendRedirect("a_coordonnees?suppression=true");
		}
		else{request.getRequestDispatcher("a_coordonnees.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


