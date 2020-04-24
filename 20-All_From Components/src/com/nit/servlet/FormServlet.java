package com.nit.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends HttpServlet  {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{

		String name=null,father=null,mother=null,gender=null,date=null,email=null,fbid=null,
				address=null,state=null,ms=null,qlfy[]=null,passed=null ,ses=null;

		String branch[]=null,college=null,university=null,hb[]=null,mon=null,fcolor=null,pweek=null;

		int age=0,pincode=0,pfee=0;
		String gradution=null,hsc=null,th=null;
		long aadhaar=0l,reg=0l,tel=0l;

		PrintWriter pw = null;
		// get PrintWriter object
		pw = res.getWriter();

		// set reponse content type
		res.setContentType("text/html");

		// read form data
		name=req.getParameter("name");
		father=req.getParameter("fname");
		mother=req.getParameter("Mname");
		date = req.getParameter("dob");
		age=Integer.parseInt(req.getParameter("age"));
		gender=req.getParameter("gender");
		email=req.getParameter("Email");
		tel=Long.parseLong(req.getParameter("phoneNo"));
		aadhaar=Long.parseLong(req.getParameter("aadhaar"));
		fbid=req.getParameter("fbid");	
		address=req.getParameter("address");
		pincode=Integer.parseInt(req.getParameter("pincode"));
		state=req.getParameter("state");
		ms = req.getParameter("ms");
		qlfy=req.getParameterValues("qlfy");
		branch=req.getParameterValues("branch");
		college = req.getParameter("college");
		university=req.getParameter("university");
		reg=Long.parseLong(req.getParameter("reg"));
		passed=req.getParameter("passout");
		ses=(req.getParameter("ses"));
		gradution=(req.getParameter("gradution"));
		hsc=(req.getParameter("hsc"));
		th =(req.getParameter("th"));
		hb=req.getParameterValues("hb");
		mon=req.getParameter("mon");
		fcolor=req.getParameter("fcolor");	
		pweek=req.getParameter("pweek");
		pfee=(int) Double.parseDouble(req.getParameter("pfee"));

		pw.println("<body bgcolor='red'>");
		pw.println("<h2 align='center'>PLEASE CHECK AND VARIFY YOUR GIVEN DETAILS BEFORE SUBMISSION</h2><br/>");
		pw.println("<table align='center'><tr><th>Person name :</th><td>"+name+"</td></tr>");
		pw.println("<tr><th>Enter father name :</th><td>"+father+"</td></tr>");
		pw.println("<tr><th>Enter mother name :</th><td>"+mother+"</td></tr>");
		pw.println("<tr><th>Dob :</th><td>"+date+"<td></tr>");
		pw.println("<tr><th>Person age :</th><td>"+age+"</td></tr>");
		pw.println("<tr><th>Gender :</th><td>"+gender+"</td></tr>");
		pw.println("<tr><th>Email :</th><td>"+email+"</td></tr>");
		pw.println("<tr><th>Mobile Number :</th><td>"+tel+"</td></tr>");
		pw.println("<tr><th>Aadhaar Number :</th><td>"+aadhaar+"</td></tr>");
		pw.println("<tr><th>Facebook Id :</th><td>"+fbid+"</td></tr>");
		pw.println("<tr><th>Address :</th><td>"+address+"</td></tr>");
		pw.println("<tr><th>Pincode :</th><td>"+pincode+"</td></tr>");
		pw.println("<tr><th>State :</th><td>"+state+"</td></tr>");
		pw.println("<tr><th>Marital Status :</th><td>"+ms+"</td></tr>");
		pw.println("<tr><th>Qualification :</th><td>"+Arrays.toString(qlfy)+"</td></tr>");
		pw.println("<tr><th>Branch :</th><td>"+Arrays.toString(branch)+"</td></tr>");
		pw.println("<tr><th>College Name :</th><td>"+college+"</td></tr>");
		pw.println("<tr><th>University/Institution :</th><td>"+university+"</td></tr>");
		pw.println("<tr><th>Registration No :</th><td>"+reg+"</td></tr>");
		pw.println("<tr><th>Passing year :</th><td>"+passed+"</td></tr>");
		pw.println("<tr><th>Session :</th><td>"+ses+"</td></tr>");
		pw.println("<tr><th>Graduation Percentage :</th><td>"+gradution+"</td></tr>");
		pw.println("<tr><th>HSC/Diploma Percentage :</th><td>"+hsc+"</td></tr>");
		pw.println("<tr><th>10th Percentage :</th><td>"+th+"</td></tr>");
		pw.println("<tr><th>Hobies :</th><td>"+Arrays.toString(hb)+"</td></tr>");
		pw.println("<tr><th>Favorite Month :</th><td>"+mon+"</td></tr>");
		pw.println("<tr><th>Favorite Color :</th><td>"+fcolor+"</td></tr>");
		pw.println("<tr><th>Favorite Week :</th><td>"+pweek+"</td></tr>");
		pw.println("<tr><th>Fee Range :</th><td>"+pfee+"</td></tr></table>");
		pw.println("</body>");
		pw.println("\n");
		pw.println(" <center><a href ='input.html'> "
				+ "<img src ='home.jpg' width='40' height='40'></a></center>");

		//close Stream
		pw.close();
	}
}