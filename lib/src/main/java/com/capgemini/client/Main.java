package com.capgemini.client;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.EmployeeDaoImplV2;
import com.capgemini.entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImplV2();
		
		Employee employee = new Employee();
		employee.setName("rahul");
		employee.setEmail("rahul@gmail.com");
		employee.setSalary(123455.0);
		
		dao.createEmployee(employee);
	}
}
