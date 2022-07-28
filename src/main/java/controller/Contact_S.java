package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContactDao;
import dao.UtilisateurDao;
import model.Contact;
import model.Utilisateur;

/**
 * Servlet implementation class Contact_S
 */
@WebServlet("/contact")
public class Contact_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContactDao CDao = new ContactDao(); 
	UtilisateurDao UDao = new UtilisateurDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean messageok = false;
		HttpSession session = request.getSession();
		Utilisateur utilisateur= new Utilisateur();
		
		if(session.getAttribute("nomuser")=="" || session.getAttribute("nomuser")==null) {
				utilisateur.setId_utilisateur(1);
				System.out.println("invité");
			}
			else {
				utilisateur=UDao.findById((int)session.getAttribute("iduser"));
				String mail=utilisateur.getEmail();
				request.setAttribute("mail", mail);
				System.out.println(utilisateur);
			}

		
		if (request.getParameter("send") != null) {
			String sujet = request.getParameter("sujet");
			String email = request.getParameter("email");
			String message = request.getParameter("message");
			Contact contact = new Contact(sujet,message,false,utilisateur,email);
			messageok = CDao.create(contact);
			System.out.println("contact créé");
			request.setAttribute("messageok", messageok);
			response.sendRedirect("index");
		}
			request.getRequestDispatcher("contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
