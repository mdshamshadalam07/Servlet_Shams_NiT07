package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:: doPost(-,-)");
		PrintWriter pw=null;
		String name=null,gen=null,tage=null;
		int age=0;
		List<String> errorsList=null;
		String vstatus=null;
		
	   //get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data (req parameter values)
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		gen=req.getParameter("gender");
		vstatus=req.getParameter("vflag");
		//enable server side form validations only when client side form validations are not done
if(vstatus.equalsIgnoreCase("no")) {
		//form validation logic (Server side)
		errorsList=new ArrayList();
		System.out.println("Server side form validation logics");
		if(name==null || name.length()==0 || name.equals("")) { //required rule
			 errorsList.add("Person name is required");
		}
		if(tage==null || tage.length()==0 || tage.equals("")) {  //required rule
			errorsList.add("Person age is required");
		}
		else {
			try {
				age=Integer.parseInt(tage);
				 if(age<=0 || age>125) {  // age range rule
					 errorsList.add("Person age must be in 1 through 125");
				 }
			}
			catch(NumberFormatException nfe) {  // age must be numberic
				errorsList.add("Person age must be numeric value");
			}
		}
		
		if(errorsList.size()!=0) {
			 for(String errMsg:errorsList) {
				pw.println("<h4 style='color:red'>"+errMsg+"</h4>"); 
			 }//for
			 return;
		}//if
    }//if
else {
	 age=Integer.parseInt(tage);
}

		
	
		//write b.logic /request processing logic
		if(gen.equalsIgnoreCase("M")) { //for Male
			if(age>=21) {
				pw.println("<h1 style='color:red'>Mr."+name+" u r elgible for marriage .. But think once </h1>");
			}
			else {
				pw.println("<h1>Mr."+name+" u r not elgible for marriage ..Be Happy </h1>");
			}
		}
		else {  //for Female
			if(age>=18) {
				pw.println("<h1>Miss."+name+" u r elgible for marriage .. But think Thrice </h1>");
			}
			else {
				pw.println("<h1>Miss."+name+" u r not elgible for marriage .. Be happy and keep others happy </h1>");
			}
		}
		
		//add home hyperlink as graphical hyperlink
		pw.println(" <center><a href ='input.html'> "
				+ "<img src ='home.jpg' width='40' height='40'></a></center>");
		
		//close stream
		pw.close();
	}//doPost(-,-)
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doPost(req,res);
	}//doGet(-,-)
	
}//class
