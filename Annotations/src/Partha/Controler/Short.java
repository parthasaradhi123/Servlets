package Partha.Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet(
		urlPatterns = { "/Short" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql:///started"), 
				@WebInitParam(name = "username", value = "root"), 
				@WebInitParam(name = "password", value = "Root@143")
		},loadOnStartup=10)


public class Short extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Connection connection=null;
	PreparedStatement ps  = null;
	
	
	
	static
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully........");
		} 
		catch (ClassNotFoundException e)
		{
 			e.printStackTrace();
		}
	}
	
	
	@Override
	public void init()
	{
		String url = getInitParameter("url");
		String user = getInitParameter("username");
		String password = getInitParameter("password");
		
	try 
	{
		connection= DriverManager.getConnection(url, user, password);
		System.out.println("Connection established successfullyyy...");
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}
		
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 
		String id = request.getParameter("id");
		String name = request.getParameter("username");
		String age = request.getParameter("age");
		String add = request.getParameter("address");
		
		String sqlInsertQuery = "insert into student(id,name,age,address) values(?,?,?,?)";
		PrintWriter out = response.getWriter();

		try 
		{
			if(connection!=null)
			{
				ps = connection.prepareStatement(sqlInsertQuery);
			}
			if(ps!=null)
			{
				ps.setInt(1, Integer.parseInt(id));
				ps.setString(2, name);
				ps.setInt(3, Integer.parseInt(age));
				ps.setString(4, add);
				
				int affected = ps.executeUpdate();
				if(affected == 1)
				{
					out.println("<h1 style='color:red; text-align:center;'>Registration Successfull...</h1>");
				}
				else
				{
					out.println("<h1 style='color:yellow; text-align:center;'>Registration Failed, Try Again with the Below Link...</h1>");
					out.println("<a href= './reg.html'/>|REGISTRATION|</a>");
				}
				
				out.close();
			}
			
		} 
		catch (SQLException e) 
		{
 			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy()
	{
		try 
		{
			connection.close();
		}
		catch (SQLException e) 
		{
 			e.printStackTrace();
		}
	}
}
