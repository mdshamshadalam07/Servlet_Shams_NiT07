 package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.vo.EmployeeVO;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private EmployeeMgmtService service;
	@Override
	public void init() throws ServletException {
		service=new EmployeeMgmtServiceImpl();
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmployeeVO vo=null;
		PrintWriter pw= null;
		EmployeeDTO dto=null;
		String result=null;
		vo=new EmployeeVO();
		vo.setEname(req.getParameter("ename"));
		vo.setEadd(req.getParameter("eadd"));
		vo.setDoj(req.getParameter("doj"));
		System.out.println(req.getParameter("doj"));
		vo.setBasicSalary(req.getParameter("basicSalary"));
		pw=res.getWriter();
		res.setContentType("text/html");
		
		dto=new EmployeeDTO();
		dto.setEname(req.getParameter("ename"));
		dto.setEadd(req.getParameter("eadd"));
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		dto.setDoj(java.sql.Date.valueOf(vo.getDoj()));
		
		try {
			result=service.registerEmployee(dto);
			pw.println("<h1 style='color:red;text-align:center'>Result ::"+result+"</h1>");
		} 
		
		catch(Exception e) {
				pw.println("<h1 style='color:green;text-align:center'> Internal Problems ---Try Again </h1>");
				e.printStackTrace();
			 }
	
		  pw.println("<center><a href ='employee_register.html'>"+" <img src ='home.jpg' width='40' height='40'></a></center>");
		 
		 
		 pw.close();
		   
		}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
