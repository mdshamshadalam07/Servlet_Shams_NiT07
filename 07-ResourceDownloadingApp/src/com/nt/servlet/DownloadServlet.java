package com.nt.servlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter; 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {
	
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DownloadServlet.doGet()");
		PrintWriter pw=null;
		File file=null;
		String fname=null;
		ServletContext sc= null;
		String mimeType=null;
		InputStream is=null; 
		OutputStream os=null;
		fname=req.getParameter("filename");
		file=new File("E:/store/"+fname);
		res.setContentLengthLong(file.length());
		sc=getServletContext();
		mimeType=sc.getMimeType("E:/store/"+fname);
		res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
		is=new FileInputStream(file);
		os=res.getOutputStream();
		res.setHeader("Content-Disposition","attachment;fileName="+fname);
		IOUtils.copy(is,os);
		pw.println("<br><br> <a href='input.html'>home</a>");
		is.close();
		os.close();
		pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DownloadServlet.doPost()");
		doGet(req,res);
	}

}
