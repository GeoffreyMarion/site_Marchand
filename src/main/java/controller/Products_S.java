package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProduitDao;
import dao.SlideDao;

/**
 * Servlet implementation class Products
 */
@WebServlet("/products")
public class Products_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProduitDao pDao = new ProduitDao();
    SlideDao slideDao = new SlideDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("ListSlide", slideDao.read());
		
		if (request.getParameter("idSCat") != null) {
			int id = Integer.parseInt(request.getParameter("idSCat"));
			request.setAttribute("ListProduit",pDao.findBySCat(id));
		}
		else if (request.getParameter("mot") != null) {
			String mot = request.getParameter("mot");
			request.setAttribute("ListProduit",pDao.findByMot(mot));
		}
		else if (request.getParameter("idCat") != null) {
			int id = Integer.parseInt(request.getParameter("idCat"));
			request.setAttribute("ListProduit",pDao.findByCat(id));
		}
		else {
			request.setAttribute("ListProduit", pDao.read());
		}
			request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
