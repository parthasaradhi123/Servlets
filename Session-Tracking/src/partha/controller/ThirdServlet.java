package partha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text.html");
		String mobile = request.getParameter("number");
		String email = request.getParameter("mail");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("mobile", mobile);
		session.setAttribute("email", email);
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>OutPut</title></head>");
		out.println("<body >");
		out.println("<center>");
		out.println("<h1>User Details.</h1>");
		out.println("<body>");
		out.println("<table border='1'>");

		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		Enumeration<String> Names = session.getAttributeNames();
		while(Names.hasMoreElements())
		{
			String atName = (String)Names.nextElement();
			Object atValue = session.getAttribute(atName);
			out.println("<tr><td>"+atName+"</td><td>"+atValue+"</td></tr>");
			
		}
		
		out.println("</tr>");
		out.println("</table>");		
		out.println("</center>");
		out.println("</html>");
		out.close();
		
	}

}
