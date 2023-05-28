package partha.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

 
@WebServlet("/SApp")
public class SApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("image/jpeg");
		 
		 File f = new File("D:\\Images\\sunny.jpeg");
		 FileInputStream fis = new FileInputStream(f);
		 
		 
		 byte[] b = new byte[(int) f.length()]; // now reading the data from image or fis and storing it into byte array
		 fis.read(b);
		 
		 ServletOutputStream stream =  response.getOutputStream();
		 stream.write(b);  // writing the data inside outputStream from byte Array.
		 
		 
		 
		 stream.flush();
		 stream.close();
		 fis.close();
}

}
