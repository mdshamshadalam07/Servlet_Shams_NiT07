package com.nit.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class VoterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		PrintWriter pw= null;
		String name = null;
		String tage = null;
		int age = 0;

		// general settings
		    pw = res.getWriter();
			res.setContentType("text/html");
       //  get request parameter values (from data)
	        name = req.getParameter("pname");
			tage = req.getParameter("page");
			age = Integer.parseInt(tage);

      // write request processing logic
	      if (age>=18) {
			  pw.println("<h1 style='color:green;text-align:center;'>" +name+"  you are Eligible for Vote</h1>");
	      }

			  else {
				  pw.println("<h1 style='color:red;text-align:center;'>"+name+"you are not Eligible for Vote</h1>");
}
  
         //   add hyperlink
               pw.println(" <center><a href = 'http://localhost:3232/VoterApp/input.html'> <img src ='home.jpg' width='40' height='40'></a></center>");


			 // close Stream
			     pw.close();
	}
} // class
