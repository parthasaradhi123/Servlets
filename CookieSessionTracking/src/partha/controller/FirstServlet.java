package partha.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		String pname = request.getParameter("pname");
		String pcost = request.getParameter("cost");
		
		Cookie c1 = new Cookie("pName",pname);
		Cookie c2 = new Cookie("pCost",pcost);

		response.addCookie(c1);
		response.addCookie(c2);
		
		RequestDispatcher reqDisp = request.getRequestDispatcher("/form2.html");
		reqDisp.forward(request, response);
		
	}

}
