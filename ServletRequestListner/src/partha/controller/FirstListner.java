package partha.controller;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

 
@WebListener
public class FirstListner implements ServletRequestListener
{

	public static int count=0;
	
     
    public FirstListner() 
    {
    	System.out.println("Object created");
     }

	 
	 
    public void requestInitialized(ServletRequestEvent sre)
    {
    	count++;
    	System.out.println("Hit count of application is "+count);
    	System.out.println("Request started.");

     }
    
    public void requestDestroyed(ServletRequestEvent sre) 
    { 
    	System.out.println("Object destroyed..");
   }
	
}
