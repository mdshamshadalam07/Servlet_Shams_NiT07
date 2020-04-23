package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExcelServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {

		// getPrintWrite 
		   PrintWriter pw=res.getWriter(); 
	   // setContent type
		   res.setContentType("application/vnd.ms-excel");
	   // write output message to reponse obj
	      pw.println("<table broder='0' align='center'>");
		  pw.println("<tr><th>Player</th><th>Role</th></tr>");
		  pw.println("<tr><td>Virat Kohli</th><th>Captan</td></tr>");
		  pw.println("<tr><td>Rohit Sharma</th><th>Opener Bastman</td></tr>");
		  pw.println("<tr><td>Yousuf Pathan</th><th>Bastman</td></tr>");
		  pw.println("<tr><td>Irfan Pathan</th><th>All Rounder</td></tr>");
		  pw.println("<tr><td>Rishabh Pant</th><th>WicketKeeper</td></tr>");
		  pw.println("<tr><td>Jasprit Bumrah</th><th>Bolwer</td></tr>");
		  pw.close();
	} // service(-,-)
} //class