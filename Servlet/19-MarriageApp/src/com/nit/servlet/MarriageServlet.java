package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	@Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
	PrintWriter pw = null;
	String name=null;
	String gender=null;
	int age=0;
	// setting Response 
	pw=res.getWriter();
	res.setContentType("text/html");
	name = req.getParameter("pname");
	gender = req.getParameter("gender");
	age=Integer.parseInt(req.getParameter("page"));
 // write request processing logic
	if(gender.equalsIgnoreCase("M")) { // for male
		
		if (age>=21) { // for male
		 pw.println("<h1 style='color:green;text-align:center;'>Mr." +name+"  you are Eligible for Marriage</h1>");
		}
	
	 else {  // for male
		 pw.println("<h1 style='color:green;text-align:center;'>Mr." +name+"  you are not Eligible for Marriage</h1>");
	  }
	}
	  
	else { // female
		
		if(age>=18) { // for female
		    pw.println("<h1 style='color:green;text-align:center;'>Miss." +name+"  you are Eligible for Marriage</h1>");
		 }
	
	
		 else {  // for female
			 pw.println("<h1 style='color:green;text-align:center;'> Miss." +name+"  you are not Eligible for Marriage</h1>");
		  }
		}
	
	// add home hyperlink as graphical hypeelink
	     pw.println(" <center><a href = 'http://localhost:4242/MarriageApp/input.html'> <img src ='home.jpg' width='40' height='40'></a></center>");
    } //close stream
}  // class