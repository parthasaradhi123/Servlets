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

 
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
     
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String brand = request.getParameter("brand");
		String quantity = request.getParameter("qan");
		
		Cookie c3 = new Cookie("brand",brand); 
		Cookie c4 = new Cookie("brand",quantity); 
		
		 response.addCookie(c3);
		 response.addCookie(c4);
		 
		RequestDispatcher reqDisp = request.getRequestDispatcher("/form3.html");
		reqDisp.forward(request, response);
		
	}

}
