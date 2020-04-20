//employeesearchservlet
package com.nt.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeSearchServlet extends HttpServlet{
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException{
		
		PrintWriter pw=null;
		int eno=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ServletConfig cg=null;
		String driver=null,url=null,user=null,pwd=null;
		try{
		//get PrintWriter
		pw=res.getWriter(); 
		//set response content type
		res.setContentType("text/html");
		//read form data
		eno=Integer.parseInt(req.getParameter("eno"));
		//get Access to ServletConfig object
         cg=getServletConfig();
         //read Servlet Init parameters
         driver=cg.getInitParameter("driver");
         url=cg.getInitParameter("url");
         user=cg.getInitParameter("dbuser");
         pwd=cg.getInitParameter("dbpwd");
         
         pw.println("<b> Searching and given details </b>");
        		 
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
		pw.println("<br> <br> logical name of servlet ::"+cg.getServletName());
		pw.println("<br> ServletConfig obj class name::"+cg.getClass());
	}//try
	catch(Exception e) {
		pw.println("<h1 style='color:red'> Internal Problem try again </h1>");
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
		pw.println("<br><br><a href='input.html'>home.jpg</a>");

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

	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException{
	doGet(req,res);
	}
	
}//class
