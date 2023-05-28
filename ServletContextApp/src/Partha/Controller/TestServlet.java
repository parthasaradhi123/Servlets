package Partha.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class TestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	static
	{
		System.out.println("TestServlet");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			PrintWriter out = response.getWriter();
			
			out.println("<html><head><title>OUTPUT</title></head>");
			out.println("<body>");
			out.println("<center>");
			
			out.println("<h1 style='color:green;'>Context Parameter Information </h1>");
	
			out.println("<form>");
			
			out.println("<table border ='1'>");
			out.println("<tr><th>ConextParameter Name</th><th>ConextParameter Value</th></tr>");
			
			ServletContext context =getServletContext();
			Enumeration<String> paramNames = context.getInitParameterNames();
			
			while(paramNames.hasMoreElements())
			{
				String name = (String)paramNames.nextElement();
				String values = context.getInitParameter(name);
				
				out.println("<tr>");
				out.println("<td>"+name+"</td>");
				out.println("<td>"+values+"</td>");
				out.println("</tr>");
				
			}
			
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		
			out.close();
			
	
	}

}
