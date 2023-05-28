package partha.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	PrintWriter out = response.getWriter();
	
	System.out.println("I am in second Servlet..");
	
	out.println("<h1 style='color:red; text-align:center;'>Now you are in second Servlet.</h1>");

	}

}
