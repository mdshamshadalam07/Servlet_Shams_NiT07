package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CoronaPatientRegistrationServlet extends HttpServlet {
	private static final String INSERT_CORONA_QUERY="INSERT INTO CORONA_REGISTRATION VALUES(CORONA_PATID_SEQ.NEXTVAR,?,?,?,?,?)";
     @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
    	  PrintWriter pw=null;
    	  String patName=null,patAddrs=null,gender=null,stage=null;
    	  int age=0;
    	  Connection con=null;
    	  PreparedStatement ps=null;
    	  int count=0;
		   // get PrintWriter
    	   pw=res.getWriter();
			//set respose content type
			res.setContentType("text/html");
			//read form data
			patName=req.getParameter("patName");
			patAddrs=req.getParameter("patAddrs");
			age=Integer.parseInt(req.getParameter("patAge"));		
			gender=req.getParameter("gender");
			stage=req.getParameter("stage");
			 
			try {
				
				//getPooled JDBc Connection Object
				con=getPooledConnection();
				// create JDBC PreparedStatement object
				 ps=con.prepareStatement(INSERT_CORONA_QUERY);
				 //set values to query params
				 ps.setString(1,patName);
				 ps.setString(2,patAddrs);
				 ps.setInt(3,age);
				 ps.setString(4,gender);
				 ps.setString(5,stage);
				 // execute the query
				 count=ps.executeUpdate();
				//process the resultSet
			    if(count==0) 
				pw.println("<h1 style='color:red;text-align:center'> Registration failed </h1>");
				else 
					pw.println("<h1 style='color:green;text-align:center'> Registration Succeded </h1>");
				 }
			    catch(SQLException se) {
					se.printStackTrace();
					 pw.println("<h1 style='color:blue;text-align:center;'> Registration failed</h1>");
					}
			  catch(Exception e) {
				e.printStackTrace();
				 pw.println("<h1 style='color:blue;text-align:center;'> Unkhow Problems </h1>");
				}
			finally {
				//close jdbc objs
				try {
				if(ps!=null)
				ps.close();
			  }
				catch(SQLException se) {
				se.printStackTrace();
				}
				
				try {
					if(con!=null)
					con.close();  // release the jdbc con obj to jdbc con pool
				  }
					catch(SQLException se) {
					se.printStackTrace();
					}
				 pw.println("<center><a href = 'http://localhost:4242/16-PoolDBApp/register.html'> <img src ='home.jpg' width='40' height='40'></a></center>");
			  try {
				if(pw!=null)
					pw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			} // finally
		} 
     @Override
	  public void doPost(final HttpServletRequest req, final HttpServletResponse res)throws ServletException,IOException {
    	  doGet(req,res);
     }
       
      private Connection getPooledConnection() throws Exception {
    	  InitialContext ic = null;
    	  DataSource ds = null;
    	  Connection con = null;
    	  // create InitialContext object
    	  ic=new InitialContext();
    	  //get DataSource object through lookup operation
    	// ds=(DataSource)ic.lookup("java:/DsJndi");
    	  ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
    	 // ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
    	  con=ds.getConnection();
    	  return con;
      } //get PooledConnection()
} // class
