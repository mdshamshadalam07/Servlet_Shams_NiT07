package com.nt.service;


import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	private EmployeeDAO dao;
	
	 public EmployeeMgmtServiceImpl() {
		dao= new EmployeeDAOImpl();
		}		
			

	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		float grossSalary=0.0f;
		float netSalary=0.0f;
		EmployeeBO bo=null;
		int count =0;
		grossSalary=dto.getBasicSalary()+ dto.getBasicSalary()*0.4f;
		netSalary=grossSalary-(grossSalary*0.2f);
		bo=new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setEadd(dto.getEadd());
		bo.setDoj(dto.getDoj());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary);
		count=dao.insert(bo);
		if(count==0)
			return "Registration Failed";
		else 
			return "Registration Succeded";
	}

}
