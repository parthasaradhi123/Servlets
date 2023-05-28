package partha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text.html");
		
		String category = request.getParameter("cat");
		String manufacture = request.getParameter("man");
		
	
		
		Cookie[] cookie = request.getCookies();
		
		String pname = cookie[0].getValue();
		String cost = cookie[1].getValue();
		String brand = cookie[2].getValue();
		//String quantity = cookie[3].getValue();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>OutPut</title></head>");
		out.println("<body >");
		out.println("<center>");
		out.println("<h1>User Details.</h1>");
		out.println("<body>");
		out.println("<table border='1'>");

		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		
		out.println("<tr><th>NAME</th><td>"+pname+"</td></tr>");
		out.println("<tr><th>AGE</th><td>"+cost+"</td></tr>");
		out.println("<tr><th>BRAND</th><td>"+brand+"</td></tr>");
	//	out.println("<tr><th>QUANTITY</th><td>"+quantity+"</td></tr>");
		out.println("<tr><th>CATEGORY</th><td>"+category+"</td></tr>");
		out.println("<tr><th>MANAFACTURE</th><td>"+manufacture+"</td></tr>");

		
		out.println("</table>");		
		out.println("</center>");
		out.println("</html>");
		out.close();
		
	}

}
