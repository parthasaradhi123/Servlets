package partha.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
     
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String qualification = request.getParameter("qua");
		String designation = request.getParameter("des");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("qua", qualification);
		session.setAttribute("des", designation);
		
		RequestDispatcher reqDisp = request.getRequestDispatcher("/form3.html");
		reqDisp.forward(request, response);
		
	}

}
