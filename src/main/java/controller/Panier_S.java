package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Panier;

/**
 * Servlet implementation class Panier_S
 */
@WebServlet("/panier")
public class Panier_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Panier_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		Panier panier=(Panier) session.getAttribute("panier");
		session.setAttribute( "panier", panier );
		boolean emptyCart = true;
		if(panier != null) {
			if(panier.count() >0) {
				emptyCart = false;
			}			
		}
		
//		SUPPRIMER UN PRODUIT => PANIER
		if(request.getParameter("idtodelete")!=null ) {
			int idproduit=Integer.valueOf(request.getParameter("idtodelete"));
			Panier panier2=(Panier) session.getAttribute("panier");
			panier2.delete(idproduit);
			if(panier.count() == 0) {
				emptyCart = true;
			}
			session.setAttribute( "panier", panier2 );
		}
		session.setAttribute("emptyCart", emptyCart);
		request.getRequestDispatcher("panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
