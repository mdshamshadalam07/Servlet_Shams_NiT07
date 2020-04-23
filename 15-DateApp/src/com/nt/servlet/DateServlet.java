package com.nt.servlet;

import javax.servlet.*;
import java.io.*;
import java.util.*;

  public class DateServlet  extends GenericServlet {
	  public DateServlet() {
          System.out.println("DateServlet::0-param constructor");
	  }  

	     public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException {
			  System.out.println("DateServlet::service(-,-)method");
          
		  Date d =null;
		  PrintWriter pw=null;

	//  get PrintWriter stream from response having response as destination
	    pw=res.getWriter();

   //  get System data and time(request processing logic)
       d=new Date();

   //  set response content Type to brower through ServletContainer/WebServer
	    res.setContentType("text/html");

   //   write generated output to reponse obj using printWriter stream
	  	pw.println("<h1 style='color:Green;text-align:center'> Date and Time ::: "+d.toString()+" </h1>");

  //   close stream
        pw.close();
     }  // service(-,-)
}  // class
