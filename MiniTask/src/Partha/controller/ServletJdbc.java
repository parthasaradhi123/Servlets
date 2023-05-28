package Partha.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletJdbc
 */
public class ServletJdbc extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	Connection connection = null;
	PreparedStatement ps = null;
	
	
	
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
	
	public void init()
	{
		String url = getInitParameter("url");
		String user = getInitParameter("user");
		String password = getInitParameter("password");
		
		try 
		{
			connection = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException e) 
		{
 			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String StringInsert = "insert into registration(Name,DOB,address,subject,gender,phn,class) values(?,?,?,?,?,?,?)";
		try 
		{
			if(connection!=null)
			{
				ps = connection.prepareStatement(StringInsert);
			}
			String dd = request.getParameter("date");
			
			DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
			java.util.Date  uDate = df.parse(dd);
			java.sql.Date  sdate = new java.sql.Date(uDate.getTime());
			
			if(ps!=null)
			{
				ps.setString(1,request.getParameter("firtname"));
				
			}
		} 
		catch (SQLException | ParseException e) 
		{
 			e.printStackTrace();
		}
 	}

}
