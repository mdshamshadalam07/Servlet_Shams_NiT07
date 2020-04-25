package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = null;
		String pname=null,fname=null,ms=null;
		
		pw = res.getWriter();
		res.setContentType("text/html");
		
		//read from1/req1 data
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		ms=req.getParameter("ms");
		
	// Generate dynamic from page based Marital Status
		if(ms.equalsIgnoreCase("single")) {
			pw.println("<h1 style='color:red;text-align:center'> Provide Bachelor Life Realted Data </h1>");
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table bgcolor='orange' align='center'>");
			pw.println("<tr><td> When do you want to marry </td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td> Why do you want to marry </td><td><input type='text' name='f2t2'></td></tr>");
		//	pw.println("<tr><td><input type='Submit' value='Submit'></td></tr>");
			
			pw.println("<tr><td><input type='Submit' value='Submit'/>"
					+ " &nbsp;<input type='reset' value='Cancel'/></td></tr>");
					
			//pw.println("/table");
			//pw.println("/form");
		}
		   
	else {
		pw.println("<h1 style='color:green;text-align:center'> Provide Marriage Life Realted Data </h1>");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("<table bgcolor='blue' align='center'>");
		pw.println("<tr><td> Spouse Name :: </td><td><input type='text' name='f2t1'></td></tr>");
		pw.println("<tr><td> Number of Children :: </td><td><input type='text' name='f2t2'></td></tr>");
	//	pw.println("<tr><td><input type='Submit' value='Submit'></td></tr>");
		
		pw.println("<tr><td><input type='Submit' value='Submit'/>"
				+ " &nbsp; <input type='reset' value='Cancel'/></td></tr>");
		
		//pw.println("/table");
		//pw.println("/form");
	  }
		
		pw.close();
	} 
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
