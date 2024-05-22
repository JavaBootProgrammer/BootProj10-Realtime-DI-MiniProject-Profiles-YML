package com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.data.model.Employee;
import com.data.service.IEmployeeMgmtService;

@Controller("empController")
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService  empService;
	
	public EmployeeOperationsController() {
		System.out.println("EmployeeOperationsController:: 0-param constructor");
	}
	
	
	public   List<Employee>   showEmployeesByDesgs(String desg1,String desg2,String desg3)throws Exception{
		//use service
		List<Employee> list=empService.fetchEmployeesByDesgs(desg1, desg2, desg3);
		return list;
	}

}
