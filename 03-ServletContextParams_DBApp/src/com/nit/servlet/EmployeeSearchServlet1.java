 
// EmployeeSearchServlet1.java

		package com.nit.servlet;

		import javax.servlet.*;
		import javax.servlet.http.*;
		import java.sql.*; // jdbc api
		import java.io.*;
		import javax.servlet.ServletException;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;

		public class EmployeeSearchServlet1 extends HttpServlet
		{
			  private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
			  public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
					PrintWriter pw=null;
					ResultSet rs=null;
					int  eno=0;
					Connection con=null;
					PreparedStatement ps = null;
					ServletContext sc=null;
					ServletConfig cg=null;
					String driver=null,url=null,user=null,pwd=null;
					try
					{
					// get PrintWriter
					    pw=res.getWriter();
					//set respose content type
					    res.setContentType("text/html");
					 // read form data from page
				    	eno=Integer.parseInt(req.getParameter("eno"));
					// get Access to ServletContext,ServletConfig object
					    sc=getServletContext();
					    cg=getServletConfig();
					// read ServletContext,ServletConfig Parameters
					    driver=sc.getInitParameter("driver");
					    url=sc.getInitParameter("url");
					    user=sc.getInitParameter("empuser");
					    pwd=sc.getInitParameter("emppwd");
					    
				     //register JDBC driver s/w
						Class.forName(driver);
						   
			        //establish the connection
					   con=DriverManager.getConnection(url,user,pwd);
					 
					 // create prepareStatement having pre-compiled Query
					  ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);

					//set values to query params
						ps.setInt(1,eno);
					   
				    //execute the Query
					    rs=ps.executeQuery();
				 
					   //process the resultSet
						if(rs.next()) {
							pw.println("<h1 style='color:green'>Employee Details are <h1>");
							pw.println("<b> emp no ::</b>"+rs.getInt(1)+"<br>");
							pw.println("<b> emp name ::</b>"+rs.getString(2)+"<br>");
							pw.println("<b> emp JOB ::</b>"+rs.getString(3)+"<br>");
							pw.println("<b> emp SAL ::</b>"+rs.getFloat(4)+"<br>");
							pw.println("<b> emp Deptno ::</b>"+rs.getFloat(5)+"<br>");
							 }

			  else {
		  // pw.println("<h1 style='color:red'> Employee not found </h1>");
		     pw.println("<h1 style='color:green;text-align:center;'>"+" Employee not found </h1>");
		  }
			 pw.println("<br> ServletContext obj class name ::"+sc.getClass());			
		     pw.println("<br> ServletConfig obj class name ::"+cg.getClass());
	} //try

		catch(SQLException se) {
		se.printStackTrace();
		//pw.println("<h1 style='color:red'> internal database problem </h1>");
		 pw.println("<h1 style='color:blue;text-align:center;'>"+"  Internal database problem </h1>");
		}

		catch(ClassNotFoundException cnf) {
		cnf.printStackTrace();
		//pw.println("<h1 style='color:red'> internal problem </h1>");
		 pw.println("<h1 style='color:green;text-align:center;'>"+"  Internal problem </h1>");
		}

		catch(Exception e) {
		e.printStackTrace();
		//pw.println("<h1 style='color:green'> Internal problem </h1>");
		 pw.println("<h1 style='color:blue;text-align:center;'>"+"  Internal problem </h1>");
		}

		finally {
		//close jdbc objs
		try {
		if(rs!=null) {
		rs.close();
		  }
		} // try

		catch(SQLException se) {
		se.printStackTrace();
		}

		try {
		if(ps!=null) {
		ps.close();
		  }
		} // try

		catch(SQLException se) {
		se.printStackTrace();
		}

		try {
		if(con!=null) {
		con.close();
		}
		 } // try
		catch(SQLException se) {
		se.printStackTrace();
		}

		 // generate the hyperlink
		//  pw.println("<br> <h2><a href='http://localhost:3434/10-DBApp/input.html'>home</a></h2>");
		// pw.println(" <center><a href = 'http://localhost:3434/10-DBApp/input.html'> <img src ='home.jpg' width='40' height='40'></a></center>");
		
		pw.println(" <center><a href ='input.html'> "
				+ "<img src ='home.jpg' width='40' height='40'></a></center>");
		} // finally
		} // doGet(--)

		public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		doGet(req,res);
		   }
		}