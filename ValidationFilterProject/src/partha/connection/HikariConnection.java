package partha.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnection 
{
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		HikariConfig config = new HikariConfig("D:\\JavaApplication\\ValidationFilterProject\\src\\partha\\connection\\Hikari.Properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource.getConnection();
		
		
	}
}
