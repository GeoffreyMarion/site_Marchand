package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SlideDao;
import model.Slide;

/**
 * Servlet implementation class A_utilisateur_S
 */
@WebServlet("/a_slide")
public class A_slide_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
      SlideDao sDao = new SlideDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_slide_S() {
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
			request.setAttribute("ListSlide", sDao.FindByMot(mot));
		}
		else {request.setAttribute("ListSlide", sDao.read());}
		
		boolean edition = false;
		boolean creation = false;
		boolean suppression = false;
		if (request.getParameter("edit") != null) {
			int edit = Integer.parseInt(request.getParameter("edit"));
			Slide slide = sDao.findById(edit);
			request.setAttribute("edit", edit);
			request.setAttribute("slide", slide);
			if (request.getParameter("c-edit") != null) {
				String titre = request.getParameter("e-titre");
				String image = request.getParameter("e-image");
				String url = request.getParameter("e-url");
				sDao.update(titre,image,url,edit);
				edition = true;
				request.setAttribute("edition", edition);
				response.sendRedirect("a_slide?edition=true");
			}else {
			request.getRequestDispatcher("a_slide.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("create") != null) {
			int create = Integer.parseInt(request.getParameter("create"));
			request.setAttribute("create", create);
			if (request.getParameter("c-create") != null) {
				String titre = request.getParameter("titre");
				String image = request.getParameter("image");
				String url = request.getParameter("url");
				Slide slide = new Slide(titre,image,url);
			sDao.create(slide);
			creation = true;
			request.setAttribute("creation", creation);
			response.sendRedirect("a_slide?creation=true");
			}
			else {
			request.getRequestDispatcher("a_slide.jsp").forward(request, response);
			}
		}
		else if (request.getParameter("suppr") != null) {
		int suppr = Integer.parseInt(request.getParameter("suppr"));
		sDao.remove(suppr);
		suppression = true;
		request.setAttribute("suppression", suppression);
		request.setAttribute("ListSlide", sDao.read());
		response.sendRedirect("a_slide?suppression=true");
		}
		else{request.getRequestDispatcher("a_slide.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


