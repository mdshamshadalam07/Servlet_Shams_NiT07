package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//@WebServlet("/registrationurl")
@WebServlet(urlPatterns ="/coronaurl",loadOnStartup = 1,name = "corona",
                         initParams = {@WebInitParam(name="p1",value="val1"),
                        		                 @WebInitParam(name="p2",value="val2")
                                               }
                        )
public class CoronaPatientRegistrationServlet extends HttpServlet {
	 private static  final String  INSERT_CORONA_QUERY="INSERT INTO CORONA_REGISTRATION VALUES(CORONA_PATID_SEQ.NEXTVAL,?,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String patName=null,patAddrs=null,gender=null,stage=null;
		int age=0;
		Connection con=null;
		PreparedStatement ps=null;
		ServletConfig cg=null;
		int count=0;
	    //get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		patName=req.getParameter("patName");
		patAddrs=req.getParameter("patAddrs");
		age=Integer.parseInt(req.getParameter("patAge"));
		gender=req.getParameter("gender");
		stage=req.getParameter("stage");
		try {
			//get Pooled JDBC con object
			con=getPooledConnection();
			//create JDBC PreparedStatement object
			ps=con.prepareStatement(INSERT_CORONA_QUERY);
			//set values to query params
			ps.setString(1, patName);
			ps.setString(2, patAddrs);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setString(5, stage);
			//execute the query
			count=ps.executeUpdate();
			//process the result
			if(count==0)
				pw.println("<h1 style='color:red;text-align:center'>Registration failed </h1>");
			else
				pw.println("<h1 style='color:green;text-align:center'>Registration succeded </h1>");
			
			//get Access to SerlvetConfig object
			cg=getServletConfig();
			pw.println("<br> p1 init param value::"+cg.getInitParameter("p1"));
			pw.println("<br> p2 init param value::"+cg.getInitParameter("p2"));
			pw.println("<br> logical name of Servlet comp::"+cg.getServletName());
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Registration failed </h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Unknow Problems </h1>");
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close(); //releases the jdbc con obj back to jdbc con pool
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			pw.println("<h1><a href='register.html'>home</a></h1>");
			
			try {
				if(pw!=null)
					pw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	private  Connection getPooledConnection() throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext object
		ic=new InitialContext();
		//get DataSource object through lookup operation
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled JDBC con object
		con=ds.getConnection();
		return con;
		
		
	}//getPooledConnection()

}//class
