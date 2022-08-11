package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FavoriDao;
import dao.VisiteDao;

/**
 * Servlet implementation class A_favori_S
 */
@WebServlet("/a_favori")
public class A_favori_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoriDao fDao = new FavoriDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_favori_S() {
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
			request.setAttribute("ListFavori", fDao.FindByMot(mot));
		}
		else {request.setAttribute("ListFavori", fDao.read());}
			request.getRequestDispatcher("a_favori.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
