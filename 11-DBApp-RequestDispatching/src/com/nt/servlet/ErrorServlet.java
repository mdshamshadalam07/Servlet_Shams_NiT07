package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/errorurl",name="err")
public class ErrorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doGet(-,-)");
	PrintWriter pw=null;
	pw=res.getWriter();
    res.setContentType("text/html");
    System.out.println("employee number::"+req.getParameter("eno"));
    pw.println("<h1 style='color:red;text-align:center'> Internal Problem --- Try Again </h1>");
    pw.println("<br><br><a href='input.html'>home</a>");
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ErrorServlet.doPost()");
		doGet(request, response);
	}

}
