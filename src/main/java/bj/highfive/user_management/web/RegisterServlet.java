package bj.highfive.user_management.web;




import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bj.highfive.user_management.bean.User;
import bj.highfive.user_management.dao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperer les données du formulaire
		//PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		// initialisatioin de l'objet java (java bean)
		User u =new User();
		u.setName(name);
		u.setEmail(email);
		u.setCity(city);
		//Appel de la classe passerelle 
	    //UserDao userDao = new UserDao();
		UserDao.createUser(u);
		
		//RequestDispatcher rd = request.getRequestDispatcher("/home");
		//rd.forward(request,response);
		response.sendRedirect("home");//aide à faire une redirection tout en maintant le bon url dans la nav bar
	}

}
