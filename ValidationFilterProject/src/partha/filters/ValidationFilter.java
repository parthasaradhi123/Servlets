package partha.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

 
public class ValidationFilter implements Filter 
{
	
	
    public ValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	 
	
    public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String ename_err_msg="",eid_err_msg="",eage_err_msg="",eEmail_err_msg="",eMobile_err_msg="";
	    boolean flag =true;
	    
		
		PrintWriter out= response.getWriter();
		
		String id = request.getParameter("eID");
		String name = request.getParameter("eName");
		String age = request.getParameter("eAge");
		String email = request.getParameter("eEmail");
		String mobile = request.getParameter("eMobile");
		
		if(id==null || id.equals(""))
		{
			eid_err_msg ="Employee Id is Required";
			flag = false;
			
		}
		else
		{
			if(!id.startsWith("VTU"))
			{
				eid_err_msg ="Employee Id should Start with VTU-";
				flag =false;
			}
			else
			{
				flag =true;
			}
		}
		
		if(name==null || name.equals(""))
		{
			ename_err_msg ="Employee Name is Required.";
			flag = false;

		}
		else
		{
			if(name.length()<=3)
			{
				ename_err_msg ="Employee Name must be more than 3 characters.";
				flag = false;
			}
			else
			{
				flag = true;
			}
		}
		
		if(age==null || age.equals(""))
		{
			eage_err_msg ="Employee Age is Required";
			flag = false;

		}
		else
		{
			if(Integer.parseInt(age)<=20 || Integer.parseInt(age)>=30)
			{
				eage_err_msg ="Employee Age should be within 20 to 30";
				flag = false;
			}
			else
			{
				flag = true;
			}
		}
		
		
		if(email==null || email.equals(""))
		{
			eEmail_err_msg ="Employee Email is Required";
			flag = false;

		}
		else
		{
			if(!email.endsWith("@gmail.com"))
			{
				eEmail_err_msg ="Employee Email must and should End with @gmail.com";
				flag = false;
			}
			else
			{
				flag = true;
			}
		}
		
		
		
		if(mobile==null || mobile.equals(""))
		{
			eMobile_err_msg ="Employee Mobile Number is Required";
			flag = false;

		}
		else
		{
			if(!mobile.startsWith("91-"))
			{
				eMobile_err_msg ="Employee Mobile Must and Should Start with 91- ";
				flag = false;
			}
			else
			{
				flag = true;
			}
		}
		
		if(flag == true)
		{
			chain.doFilter(request, response);
		}
		else
		{
			out.println("<html><head><title>Registration Form</title></head>");
			out.println("<body bgcolor='#eccfcf'>");
			out.println("<center>");
			out.println("<h1 style='color:green'>The Student Details.</h1>");
			
			out.println("<form method='post' action='./test'>");
			out.println("<table>");
			
			out.println("<tr><th>ID : </th><td><input type='text' name='eID' value='"+id+"' /></td>"
					+ "<td><font color='red' size='5'>"+eid_err_msg+"</font></td></tr>");
			
			out.println("<tr><th>NAME : </th><td><input type='text' name='eName' value='"+name+"' /></td>"
					+ "<td><font color='red' size='5'>"+ename_err_msg+"</font></td></tr>");
			
			out.println("<tr><th>AGE : </th><td><input type='text' name='eAge' value='"+age+"' /></td>"
					+ "<td><font color='red' size='5'>"+eage_err_msg+"</font></td></tr>");
			
			out.println("<tr><th>EMAIL : </th><td><input type='text' name='eEmail' value='"+email+"' /></td>"
					+ "<td><font color='red' size='5'>"+eEmail_err_msg+"</font></td></tr>");
			
			out.println("<tr><th>MOBIE : </th><td><input type='text' name='eMobile' value='"+mobile+"' /></td>"
					+ "<td><font color='red' size='5'>"+eMobile_err_msg+"</font></td></tr>");
			
			out.println("<tr><th>SUBMIT : </th><td><input type='submit' value='Register-Now'/></td> </tr>");
			
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}

	 
	

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
