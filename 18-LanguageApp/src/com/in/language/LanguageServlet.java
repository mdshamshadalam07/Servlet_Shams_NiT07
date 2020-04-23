package com.in.language;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
//import javax.servlet.httpServlet;
//import javax.servlet.httpServletRequest;
//import javax.servlet.httpServletResponse;

public class LanguageServlet extends HttpServlet {
	@Override
	public  void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		// getPrintWrite 
		   PrintWriter pw=null;

		   Iterator<String> li=null;
		   LinkedHashSet<String> has=null;
		   pw= res.getWriter(); 
		   has=new LinkedHashSet<String>();
		   Locale[ ] l =Locale.getAvailableLocales();
		   for(int i = 0; i <l.length; i++) {
			   has.add(l [i].getDisplayLanguage());
		   }  // for
		  	  
	    // setContent type
		   res.setContentType("text/html");
		   li = has.iterator();

		   while(li.hasNext()) {
			   String object = li.next();

	   // write output message to reponse obj
	      pw.println("<h3 style='color:red;font-style:italic;text-align:center'>"+object+"</h3>");
		 
	} // service(-,-)
  } //class
}