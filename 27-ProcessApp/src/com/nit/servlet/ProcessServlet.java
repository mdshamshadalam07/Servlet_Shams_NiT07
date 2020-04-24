package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String comp=null;
		int val1=0,val2=0;
		// get PrintWriter object
		pw=res.getWriter();
		// set reposne content type
		res.setContentType("text/html");
		//read s1 req param values to khow the components that
		comp=req.getParameter("s1");
		// write logic 
		if (comp.equals("link1")) { // system date
			pw.println("Date and Time"+new Date(val2));
		}
		
		else if (comp.equals("link2")) { // sys props
				pw.println("System.getProperties"+System.getProperties());
		}
		
		else if (comp.equals("add")) { // for add button
			// read data 
			   val1 = Integer.parseInt(req.getParameter("t1"));
			   val2 = Integer.parseInt(req.getParameter("t2"));
			   pw.print("Addition"+(val1+val2));
		}
		
		else if(comp.equals("Sub")) {
			// read from data 
			val1 = Integer.parseInt(req.getParameter("t1"));
			   val2 = Integer.parseInt(req.getParameter("t2"));
			   pw.print("Subtraction"+(val1+val2));
		}
		
		else if(comp.equals("mul")) {
			// read from data 
			val1 = Integer.parseInt(req.getParameter("t1"));
			   val2 = Integer.parseInt(req.getParameter("t2"));
			   pw.print("Multiplication"+(val1+val2));
		}
		
		else if(comp.equals("div")) {
			// read from data 
			val1 = Integer.parseInt(req.getParameter("t1"));
			   val2 = Integer.parseInt(req.getParameter("t2"));
			   pw.print("Division"+(val1+val2));
		}
		// add hyperlink
		pw.println(" <center><a href ='page.html'> "
				+ "<img src ='home.jpg' width='40' height='40'></a></center>");
	}// doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
}