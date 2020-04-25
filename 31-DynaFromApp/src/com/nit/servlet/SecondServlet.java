package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = null;
		String pname=null,fname=null,ms=null;
		String f2val1=null,f2val2=null;
		
		pw = res.getWriter();
		res.setContentType("text/html");
		
		//read from1/req1 data
				pname=req.getParameter("pname");
				fname=req.getParameter("fname");
				ms=req.getParameter("ms");
		
				//read from2/req2 data
				f2val1=req.getParameter("f2t1");
				f2val2=req.getParameter("f2t2");
			
		
	    // Display dynamic wabpage having both form1/req data and form2/req2 
		    pw.println("<h1 style='color:Red;text-align:center'> Result Page </h1>");
			pw.println("<br> form1/req1 data::"+pname+"......"+fname+"......."+ms);
			pw.println("<br> form2/req2 data::"+f2val1+"......"+f2val2);
			
			// hyper link
			pw.println(" <center><a href ='input.html'> "
					+ "<img src ='home.jpg' width='40' height='40'></a></center>");
			
			// close Stream
		        pw.close();
	} 
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
