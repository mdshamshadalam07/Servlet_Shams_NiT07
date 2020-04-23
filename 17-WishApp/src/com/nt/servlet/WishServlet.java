package com.nt.servlet;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

public class WishServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
           
		    PrintWriter pw=null;
			Calendar calendar=null;
			int hour=0;
		 
		// Genaral Settings
		    pw=res.getWriter(); 

	   //  setContent type
		   res.setContentType("text/html");

		// Get System Date
		   calendar=Calendar.getInstance();
		   hour=calendar.get(Calendar.HOUR_OF_DAY);

		//  genarate the wishmessage
		    if(hour<=12)

	   // write output message to reponse obj
	   pw.println("<center>");
	   if(hour<=12)
	      pw.println("<h1 style='color:red'>Good Morning<h1>");
		  else if(hour<=16)
		      pw.println("<h1 style='color:red'>Good AfterNoon<h1>");
		  else if(hour<=20)
		      pw.println("<h1 style='color:red'>Good Evening<h1>");
		  else
			   pw.println("<h1 style='color:red'>Good Night<h1>");
		  // generate the hyperlink
	   pw.println(" <center><a href ='page.html'> "
				+ "<img src ='home.jpg' width='40' height='40'></a></center>");
			   

	  // close the Stream
		  pw.close();
	} // service(-,-)
} //class