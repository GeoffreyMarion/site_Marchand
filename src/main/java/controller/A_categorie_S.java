package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategorieDao;
import model.Categorie;
import model.Sous_categorie;

/**
 * Servlet implementation class A_categorie_S
 */
@WebServlet("/a_categorie")
public class A_categorie_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategorieDao cDao = new CategorieDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_categorie_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setAttribute("ListCat", cDao.read());
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;

		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Categorie categorie = cDao.findById(edit);
			
			request.setAttribute("edit", edit);
			request.setAttribute("categorie", categorie);

			if (request.getParameter("c-edit") != null) {
				String titre = request.getParameter("e-titre");
				cDao.update(titre, edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_categorie?edition=true");
			} else {
				request.getRequestDispatcher("a_categorie.jsp").forward(request, response);
			}
		} else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);

			if (request.getParameter("c-create") != null) {
				String titre = request.getParameter("titre");
				Categorie categorie = new Categorie(titre);
				cDao.create(categorie);
				creation = true;
				request.setAttribute("creation", creation);
				response.sendRedirect("a_categorie?creation=true");
			} else {
				request.getRequestDispatcher("a_categorie.jsp").forward(request, response);
			}
		} else if (request.getParameter("suppr") != null) {
			int suppr = Integer.parseInt(request.getParameter("suppr"));
			cDao.remove(suppr);
			suppression = true;
			request.setAttribute("suppression", suppression);
			request.setAttribute("ListCat", cDao.read());
			response.sendRedirect("a_categorie?suppression=true");
		} else {
			request.getRequestDispatcher("a_categorie.jsp").forward(request, response);
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
