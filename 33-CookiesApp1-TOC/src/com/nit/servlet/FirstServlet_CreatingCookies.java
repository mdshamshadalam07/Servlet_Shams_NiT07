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


@WebServlet("/createurl")
public class FirstServlet_CreatingCookies extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		Cookie ck1=null, ck2=null, ck3=null,ck4=null;
		
		// General Settings
		   pw=res.getWriter();
		   
		// setContent Type
		   res.setContentType("text/html");
		
		// Create Cookies(In Memory Cookies)
		   ck1=new Cookie("ap","Hyderabad");
		   ck2=new Cookie("mh","Mumbai");
		   
		   res.addCookie(ck1);
		   res.addCookie(ck2);
		   
		   
		// Create Cookies(Persistent Cookies)
		   ck3=new Cookie("bs","Kolkata");
		   ck4=new Cookie("mp","Bhopal");
		   
		   ck3.setMaxAge(120);
		   ck4.setMaxAge(60);
		   
		   res.addCookie(ck3);
		   res.addCookie(ck4);
		   
		   pw.println("<b> Cookies Created and added response...........");
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
