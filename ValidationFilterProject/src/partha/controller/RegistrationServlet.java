package partha.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partha.dao.EmployeeDaoImpl;
import partha.dto.Employee;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("eID");
		String name = request.getParameter("eName");
		String age = request.getParameter("eAge");
		String email = request.getParameter("eEmail");
		String mobile = request.getParameter("eMobile");
		
		
		Employee employee = new Employee();
		
		employee.setId(id);
		employee.setName(name);
		employee.setAge(Integer.parseInt(age));
		employee.setEmail(email);
		employee.setMobile(mobile);
		
		EmployeeDaoImpl con = new EmployeeDaoImpl();
		
		String status = con.addEmployee(employee);
		
		 
		
		
		out.println("<html><head><title>Registration Form</title></head>");
		out.println("<body bgcolor='#eccfcf'>");
		out.println("<center>");
		out.println("<h1 style='color:green'>The Student Details.</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>ID</th><td>"+id+"</td></tr>");
		out.println("<tr><th>NAME</th><td>"+name+"</td></tr>");
		out.println("<tr><th>AGE</th><td>"+age+"</td></tr>");
		out.println("<tr><th>EMAIL</th><td>"+email+"</td></tr>");
		out.println("<tr><th>MOBILE</th><td>"+mobile+"</td></tr>");
		out.println("<tr><th>STATUS</th><td>"+status+"</td></tr>");

		
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}

}
