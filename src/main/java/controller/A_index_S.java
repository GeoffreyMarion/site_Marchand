package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SlideDao;
import dao.Sous_categorieDao;


/**
 * Servlet implementation class Utilisateur_S
 */
@WebServlet("/a_index")
public class A_index_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Sous_categorieDao sous_categorieDao = new Sous_categorieDao();
	SlideDao slideDao = new SlideDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_index_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		request.setAttribute("ListImages", sous_categorieDao.ReadImgsProd());
//		request.setAttribute("ListSlide", slideDao.read());
		request.getRequestDispatcher("a_index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
