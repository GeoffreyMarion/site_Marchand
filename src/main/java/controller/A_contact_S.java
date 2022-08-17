package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContactDao;
import model.Contact;

/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_contact")
public class A_contact_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ContactDao cDao = new ContactDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_contact_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
//		if(request.getParameter("mot") != null) {
//			String mot = request.getParameter("mot");
//			request.setAttribute("ListContact", cDao.FindByMot(mot));
//		}
//		else {request.setAttribute("ListContact", cDao.read());}
//		
//		boolean edition = false;
//		boolean creation = false;
//		boolean suppression = false;
//		if (request.getParameter("edit") != null) {
//			int edit = Integer.parseInt(request.getParameter("edit"));
//			Contact contact = cDao.findById(edit);
//			request.setAttribute("edit", edit);
//			request.setAttribute("administrateur", contact);
//			if (request.getParameter("c-edit") != null) {
//				String nom = request.getParameter("e-nom");
//				String email = request.getParameter("e-email");
//				String mot_de_passe = request.getParameter("e-mot_de_passe");
//				String privileges = request.getParameter("e-privileges");
//				cDao.update(nom,email,mot_de_passe,privileges,edit);
//				edition = true;
//				request.setAttribute("edition", edition);
//				response.sendRedirect("a_contact?edition=true");
//			}else {
//			request.getRequestDispatcher("a_contact.jsp").forward(request, response);
//			}
//		}
//		else if (request.getParameter("create") != null) {
//			int create = Integer.parseInt(request.getParameter("create"));
//			request.setAttribute("create", create);
//			if (request.getParameter("c-create") != null) {
//				String nom = request.getParameter("nom");
//				String email = request.getParameter("email");
//				String mot_de_passe = request.getParameter("mot_de_passe");
//				String privileges = request.getParameter("privileges");
//				Administrateur administrateur = new Administrateur(nom,email,mot_de_passe,privileges);
//				cDao.create(administrateur);
//			creation = true;
//			request.setAttribute("creation", creation);
//			response.sendRedirect("a_contact?creation=true");
//			}
//			else {
//			request.getRequestDispatcher("a_contact.jsp").forward(request, response);
//			}
//		}
//		else if (request.getParameter("suppr") != null) {
//		int suppr = Integer.parseInt(request.getParameter("suppr"));
//		cDao.remove(suppr);
//		suppression = true;
//		request.setAttribute("suppression", suppression);
//		request.setAttribute("ListContact", cDao.read());
//		response.sendRedirect("a_contact?suppression=true");
//		}
		request.setAttribute("ListContact", cDao.read());
		request.getRequestDispatcher("a_contact_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


