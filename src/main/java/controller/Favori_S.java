package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FavoriDao;
import dao.ProduitDao;

/**
 * Servlet implementation class Favori_S
 */
@WebServlet("/favori")
public class Favori_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoriDao fDao = new FavoriDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favori_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if ((int)session.getAttribute("iduser") != 1) {
			int id = (int)session.getAttribute("iduser");
			request.setAttribute("id", id);
			request.setAttribute("ListFavori", fDao.findByU(id));
		}
		request.getRequestDispatcher("favori.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
