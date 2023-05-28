package partha.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		
		out.println("<h1 style='color:red; text-align:center;'>Hi This Is my first Servlet.</h1>");
		
		System.out.println("I am in first Servlet.");
		
		RequestDispatcher reqDisp = request.getRequestDispatcher("/SecondServlet");
		reqDisp.forward(request, response);
	}

}
