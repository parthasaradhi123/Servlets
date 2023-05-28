package Partha.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String acType = request.getParameter("acType");
		String acBranch = request.getParameter("acBranch");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("acType", acType);
		session.setAttribute("acBranch", acBranch);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Deposit Form.</title></head>");
		out.println("<body bgcolor='cyan'>");
		
		out.println("<center>");
		out.println("<h1 style='color:green;'>Deposit form</h1>");
		
		out.println("<form  method='post' action='"+response.encodeURL("./third")+"'>");
		out.println("<table>");
		
		out.println("<tr><th>Despositor Name</th><td><input type='text' name='depName'/></td></tr>");
		out.println("<tr><th>Deposit Amount</th><td><input type='text' name='depAmount'/></td></tr>");
		out.println("<tr><th>Submit</th><td><input type='submit' value='next'/></td></tr>");

		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}

}
