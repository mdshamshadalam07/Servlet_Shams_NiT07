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


@WebServlet("/showurl")
public class SecondServlet_ShowdingCookies extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		Cookie cookies [] =null;
		
		// General Settings
		   pw=res.getWriter();
		   
		// setContent Type
		   res.setContentType("text/html");
		   
		// read Cookies
		   cookies=req.getCookies();
		
		// Display cookies
		   pw.println("<b> Displaying Cookies");
		   if (cookies!=null) {
			   pw.println("<table border='1' bgcolor = 'cyan'>");
			   pw.println("<tr><th>Cookie Name </th><th> Cookie Value </th></tr>");
			   for(Cookie ck:cookies) {
				   pw.println("<tr><td>"+ck.getName()+"</td><td>"+ ck.getValue()+ "</td></tr>");
			   		
		   }
			   pw.println("</table>");	
	    } 
		   else {
			   pw.println("<b> No Cookies Persrnt </b>"); 
			   
		   }
		   
		  
		// close stream
		   pw.close();
	}
    
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
