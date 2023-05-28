package partha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	static
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
 			e.printStackTrace();
		}
	}
	
	
	public void init()throws ServletException
	{
		String url = getInitParameter("url");
		String user = getInitParameter("username");
     	String	password=getInitParameter("password");
		
		try
		{
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("conection established....");
			
			
		}
		catch (SQLException e)
		{
 			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();

		out.println("The reQuest type is :: GET");
		
		try
		{
			if(connection!=null)
			{
				statement = connection.createStatement();
			}
		
		System.out.println("hi hello...");
		
		 if(statement!=null)
		 {
			resultset = statement.executeQuery("select*from student where id =1");
			//int x = statement.executeUpdate("update student set name = 'okay' where id =4");
			
			//System.out.println("rows effected is :: "+x);
		 }
			 if(resultset.next())
			 	{
				 	//out.println(resultset.getString("name"));
			 		System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3)+"\t"+resultset.getString(4));
			 	}
			} 
			
		
		 catch (SQLException e) 
		 
		 {
			e.printStackTrace();
		}
		
 	 

  }
}
