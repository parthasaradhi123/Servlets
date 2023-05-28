package partha.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("username");
		String Age = request.getParameter("age");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", userName);
		session.setAttribute("age", Age);
		
		RequestDispatcher reqDisp = request.getRequestDispatcher("/form2.html");
		reqDisp.forward(request, response);
		
	}

}
