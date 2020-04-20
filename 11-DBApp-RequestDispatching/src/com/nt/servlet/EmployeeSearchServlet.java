//employeesearchservlet
package com.nt.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeSearchServlet extends HttpServlet{
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		System.out.println("EmployeeSearchServlet.doGet()");
		
		PrintWriter pw=null;
		int eno=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ServletConfig cg=null;
		String driver=null,url=null,user=null,pwd=null;
		RequestDispatcher rd=null,rd1=null,rd2=null;
		try{
			
			
		//get PrintWriter
		pw=res.getWriter(); 
		//set response content type
		res.setContentType("text/html");
		
		// header content
		  rd1=req.getRequestDispatcher("/headerurl");
		  rd1.include(req, res);
		
		//read form data
		eno=Integer.parseInt(req.getParameter("eno"));
		//get Access to ServletConfig object
         cg=getServletConfig();
         //read Servlet Init parameters
         driver=cg.getInitParameter("driver");
         url=cg.getInitParameter("url");
         user=cg.getInitParameter("dbuser");
         pwd=cg.getInitParameter("dbpwd");
         
         pw.println("<b> Searching and given details </b><br>");
        		 
		//register jdbc driver
		Class.forName(driver);
		//create connection
		con=DriverManager.getConnection(url,user,pwd);
		//create prepared statement having pre compiled query
		ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
		//set query param values
		ps.setInt(1,eno);
		//execute the query
		rs=ps.executeQuery();
		//process the resultset object
		if(rs.next()){
			pw.println("<h1> Employee Details are </h1>");
			pw.println("<b> empno::"+rs.getInt(1)+"<br>");
			pw.println("<b> emp name::"+rs.getString(2)+"<br>");
			pw.println("<b> emp JOB::"+rs.getString(3)+"<br>");
			pw.println("<b> emp SAL::"+rs.getString(4)+"<br>");
			pw.println("<b> emp DEPTNO::"+rs.getString(5)+"<br>");
		}
		else{
			pw.println("<h1 style='color:red'> Employee Not Found </h1>");
		}
		
		// footer content
		  rd2=req.getRequestDispatcher("/footer.html");
		  rd2.include(req, res);	
		
	}//try
	catch(Exception e) {
		 rd=req.getRequestDispatcher("/errorurl");
		 rd.forward(req,res);
		 e.printStackTrace();
	}
		
		
	finally{
		//close jbdc objects
		try{
			if(rs!=null){
				rs.close();
			}
		}
		catch(SQLException se){
			
		}
		
		try{
			if(con!=null){
				rs.close();
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
		//home hyperlink
		pw.println(" <center><a href ='input.html'> "
				+ "<img src ='home.jpg' width='40' height='40'></a></center>");

		try{
			if(pw!=null){
				pw.close();
			}
		}
		catch(Exception se){
			se.printStackTrace();
		}
		
		
		
	}//finally
	
}//doget	

	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
	}
	
}//class
