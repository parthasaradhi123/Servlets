package Partha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String depName = request.getParameter("depName");
		String depAmount = request.getParameter("depAmount");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("depName", depName);
		session.setAttribute("depAmount", depAmount);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Deposit Form.</title></head>");
		out.println("<body >");
		
		out.println("<center>");
		out.println("<h1 style='color:green;'>Deposit form</h1>");
		
 		out.println("<table border='1'>");
		
 		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
 		
 	Enumeration<String> Names = session.getAttributeNames();
 	while(Names.hasMoreElements())
 	{
 		String attName = (String)Names.nextElement();
 		Object attValue=	session.getAttribute(attName);
 		
		out.println("<tr>");
		out.println("<td>"+attName+"</td>");
		out.println("<td>"+attValue+"</td>");
		out.println("</tr>");

 	}
 	
		 

		out.println("</table>");
 		out.println("</center>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
