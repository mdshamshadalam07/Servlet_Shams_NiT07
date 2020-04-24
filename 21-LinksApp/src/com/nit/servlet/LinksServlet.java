package com.nit.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LinksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = null;
		String link=null;
		Locale locales[]=null;
		// get PrintWriter object
		pw = res.getWriter();

		// set reponse content type
		res.setContentType("text/html");
		// read "s1"req param values to khows the hyperink that is clicked
		link=req.getParameter("s1");
		
		if(link.equalsIgnoreCase("link1")) { // all languages
			pw.println("<h2 align='center'>PLEASE CHECK YOUR GIVEN LANGUAGES</h2>");
			// get all available locales
			locales=Locale.getAvailableLocales();
		     for(Locale lc:locales) {
		    	 pw.println("<center>"+lc.getDisplayLanguage()+"<br></center>"); 
		     }
		     pw.println(" <center><a href ='page.html'> "
						+ "<img src ='home.jpg' width='40' height='40'></a></center>");
     	} //if
	  
	else if(link.equalsIgnoreCase("link2")) {
		pw.println("<h2 align='center'>PLEASE CHECK YOUR GIVEN COUNTRIES NAMES </h2><br/>");
		// get all availale locales
		   locales=Locale.getAvailableLocales();
		   for(Locale lc:locales) {
			   pw.println("<center>"+lc.getDisplayCountry()+"<br></center>"); 
			  
		   }
		   pw.println(" <center><a href ='page.html'> "
					+ "<img src ='home.jpg' width='40' height='40'></a></center>");
		   
	}// else
	    
	else {
		pw.println("<h2 align='center'>PLEASE CHECK YOUR DATE AND TIMES</h2><br/>");
		  pw.println("<center> Date and Time :" +new Date()+"<br></center>");
		  
		  // add hyperlink
		//   pw.println("<a href='page.html'>home</a>");
		  pw.println(" <center><a href ='page.html'> "
					+ "<img src ='home.jpg' width='40' height='40'></a></center>");
	   }
	}// doGet(-,-)
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
               doGet(req,res);
	}
}// class

               