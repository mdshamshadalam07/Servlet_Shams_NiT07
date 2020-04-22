package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = null;
		String ss = null;
		String engine=null;
		String url=null;
		pw = res.getWriter();
		res.setContentType("text/html");
		ss=req.getParameter("s");
		engine=req.getParameter("engine");
		if(engine.equalsIgnoreCase("google")) {
		url="https://www.google.com/search?q="+ss;
		}
	    else if (engine.equalsIgnoreCase("bing")) {
		url="https://www.bing.com/search?q="+ss;
	    }
		else if(engine.equalsIgnoreCase("yahoo")) {
		url="https://in.search.yahoo.com/search?p="+ss;
		}
		else if(engine.equalsIgnoreCase("youtube")) {
		url="https://www.Youtube.com/search?p="+ss;
		}
		System.out.println("before res.sendRedirect(-) method");
		pw.println("<br> before .....</br>");
		res.sendRedirect(url);
		
		System.out.println("after res.sendRedirect(-) method");
		pw.println("<br> after .....</br>");	
		pw.close();
	}
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
