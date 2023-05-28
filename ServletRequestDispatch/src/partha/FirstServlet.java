package partha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/valid")
public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 System.out.println("Control in servlet one ");
		 
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 System.out.println("USER-NAME: "+username+"\t PASSWORD : "+password);
		 
		 if(username.contentEquals("partha") && password.contentEquals("root"))
		 {
			RequestDispatcher reqDisp =  request.getRequestDispatcher("/home.jsp");
			reqDisp.forward(request, response);
		 }
		 else
		 {
			 ServletContext servContext = request.getServletContext();
			 RequestDispatcher reqDisp1 =  servContext.getRequestDispatcher("/error.jsp");
				reqDisp1.forward(request, response);

		 }
		 
	}

}
