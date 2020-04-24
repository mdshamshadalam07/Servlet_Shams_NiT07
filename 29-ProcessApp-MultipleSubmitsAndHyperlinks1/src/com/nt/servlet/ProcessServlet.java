package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		float val1=0.0f,val2=0.0f;
		String pval=null;
		//get PrintWriter 
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read Source req param value (hidden box)
		pval=req.getParameter("source");
		if(!pval.equalsIgnoreCase("link")) {
	    	//read form data
		   val1=Float.parseFloat(req.getParameter("first"));
		   val2=Float.parseFloat(req.getParameter("second"));
		}
		//Differentiate logics from submit buttons and hyperlinks
		if(pval.equalsIgnoreCase("add")) {
			pw.println("<b> Addition:::"+(val1+val2));
		}
		else if(pval.equalsIgnoreCase("sub")) {
			pw.println("<b> Subtraction:::"+(val1-val2));
		}
		else if(pval.equalsIgnoreCase("mul")) {
			pw.println("<b> Multiplication:::"+(val1*val2));
		}
		else if(pval.equalsIgnoreCase("div")) {
			pw.println("<b> Division:::"+(val1/val2));
		}
		else {
			pw.println("<b>System Properties are </b>:::"+System.getProperties());
		}
		//add hyperlink
		pw.println("<br><br><a href='form.html'>home</a>");
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
