package partha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import partha.connection.HikariConnection;
import partha.dto.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public String addEmployee(Employee employee) 
	{
		
		Connection connection = null;
		PreparedStatement ps = null;
				
		try 
		{
			connection = HikariConnection.getConnection();
			
			String sqlInsertQuery = "insert into Employee(id,name,age,email,mobile)values(?,?,?,?,?)";
			
			if(connection!=null)
			{
				ps = connection.prepareStatement(sqlInsertQuery);
			}
			if(ps!=null)
			{
				ps.setInt(1, Integer.parseInt(employee.getId()));
				ps.setString(2, employee.getName());
				ps.setInt(3, employee.getAge());
				ps.setString(4, employee.getEmail());
				ps.setString(5, employee.getMobile());
				
				
				int rowAffected = ps.executeUpdate();
				
				if(rowAffected==1)
				{
					return "Registration Successfull.";
				}
				else
				{
					return "Registration Failed.";
				}
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
 		return null;
	}

}
