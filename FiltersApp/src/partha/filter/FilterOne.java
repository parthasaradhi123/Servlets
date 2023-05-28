package partha.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

 
public class FilterOne implements Filter {

     
    public FilterOne() {
        // TODO Auto-generated constructor stub
    }

	 
	
    public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	 
 
		PrintWriter out = response.getWriter();
		out.println("<h1>Before</h1>");
		
		chain.doFilter(request, response);
		out.println("<h1>After</h1>");

	}
 
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
