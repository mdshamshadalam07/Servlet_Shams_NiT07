 package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
		/* 
		 public TestServlet () {
			 System.out.println("TestServlet ::0-param constructor");
			 ServletConfig cg=getServletConfig();
			 ServletContext sc=cg.getServletContext();
			 System.out.println("empuser init param value ::"+cg.getInitParameter("empuser"));
			 System.out.println("empuser context param value ::"+sc.getInitParameter("empuser"));
		 }
		 */
		 @Override
		 public void init() throws ServletException {
			 System.out.println("TestServlet.init()");
			 ServletConfig cg=getServletConfig();
			 ServletContext sc=cg.getServletContext();
			 System.out.println("empuser init param value ::"+cg.getInitParameter("empuser"));
			 System.out.println("empuser context param value ::"+sc.getInitParameter("empuser"));
		 }
		 
		 
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		 PrintWriter pw=null;
		 ServletContext sc=null;
		 pw=res.getWriter();
		 res.setContentType("text/html");
		// get Access to servletConfig object
		    sc=getServletContext();
		    pw.println("<br> emp user Servlet Context parameter value ::"+sc.getInitParameter("empuser"));
		    
		    pw.println("<br><br> Details using ServletContext object<br><br>");
		    pw.println("<br> Server Info ::"+sc.getServerInfo());
		    pw.println("<br> Server api version ::"+sc.getMajorVersion()+"."+sc.getEffectiveMinorVersion());
		    pw.println("<br>MIME type of input.html Is:"+sc.getMimeType("input.html"));
		    pw.println("<br> Path of input.html :"+sc.getRealPath("/input.html"));
		    pw.println("<br> Path of web root folder ::"+sc.getRealPath("/"));
		    pw.println("<br> Context path of the web apllication ::"+sc.getContextPath());
		    
		    pw.close();
	 }
 
	 public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		 doGet(req,res);
	 
    }
} 

