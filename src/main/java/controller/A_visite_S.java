package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RechercheDao;
import dao.VisiteDao;

/**
 * Servlet implementation class A_visite_S
 */
@WebServlet("/a_visite")
public class A_visite_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VisiteDao vDao = new VisiteDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_visite_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("s-date") != null) {
			String date = request.getParameter("date");
			request.setAttribute("ListVisite", vDao.findByD(date));
		}		
		else if(request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListVisite", vDao.FindByMot(mot));
		}
		else {request.setAttribute("ListVisite", vDao.read());}
			request.getRequestDispatcher("a_visite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
