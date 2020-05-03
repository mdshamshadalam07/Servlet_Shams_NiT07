package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		String name=null,fname=null, gender=null;
		Cookie cookie1=null, cookie2=null, cookie3=null;
		HttpSession ses=null;
		
		// General Settings
		   pw=res.getWriter();
		   
		// setContent Type
		   res.setContentType("text/html");
		
		// read from1/req1 data 
		   name=req.getParameter("pname");
		   fname=req.getParameter("fname");
		   gender=req.getParameter("gender");
		
		// create session object and begin the session
		   ses=req.getSession();
		   
		// write from1/req1 data to session object as session Attributes
		   ses.setAttribute("name",name);
		   ses.setAttribute("fname",fname);
		   ses.setAttribute("gender", gender);
		   
		// Generate form2 dynamically here
		   pw.println("<h1 style='color:red;text-align:center'> Provide Income Details </h1>");
		   pw.println("<form action='secondurl' method='POST'>");
		   pw.println("<table border='0' bgcolor='green' align='center'>");
		   pw.println("<tr><td> Income of this year </td><td><input type='text' name='income'</td></tr>");
		   pw.println("<tr><td> Income Tax </td><td><input type='text' name='tax'</td></tr>");
		   pw.println("<tr><td> <input type='submit' value='Submit' />"
		   		               + " <input type='reset' value='Cancel'/></td><tr>");
		   
		   pw.println("</table> </form>");
		   pw.println("<br>Session Id:::"+ ses.getId());
		   
		// close stream
		   pw.close();		
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
 