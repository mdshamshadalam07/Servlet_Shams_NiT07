package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class UploadServlet extends HttpServlet {
	
 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest nreq=null;	
		UploadBean bean=null;
		Vector vector=null;
		UploadParameters param=null;
		
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 
		 try {
			 nreq=new MultipartFormDataRequest(req);
			 bean=new UploadBean();
			 bean.setFolderstore("e:/store");
			 bean.setOverwrite(false);
			 bean.setMaxfiles(10);
			 bean.setFilesizelimit(90*1024);
			 //bean.setFilesizelimit(20*1024);
			 bean.setBlacklist("*.exe,*.zip,*.png,*.jpg");
			// bean.setBlacklist("*.exe,*.zip,");
			 bean.store(nreq);
			 pw.println("<h1 style='color:green;text-align:center'> Files are uploaded successfully </h1>");
			 vector=bean.getHistory();
			 for(int i=0; i<vector.size(); ++i) {
			 param=(UploadParameters)vector.elementAt(i);
			 pw.println("<b> file::"+param.getFilename()+"size::"+param.getFilesize()+"type::"+param.getContenttype()+"model::"+param.getStoreinfo()+"</b><br>");	 
		 }
	}
	 
	catch(Exception e) {
		
		pw.println("<h2 style='color:red;text-align:center'> Problem in uploading -->"+e.getMessage()+"</h2>");
		e.printStackTrace();
	 }
		
	  pw.println("<center><a href ='upload.html'> " + " <img src ='home.jpg' width='40' height='40'></a></center>");
	  
	
	 pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}