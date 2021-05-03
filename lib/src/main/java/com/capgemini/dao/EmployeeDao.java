package com.capgemini.dao;

import java.util.List;

import com.capgemini.entities.Employee;

// CRUD
public interface EmployeeDao {
	
	// txn
	public boolean createEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
	
	// !txn
	public Employee findById(int id);
	public List<Employee> findAll();

}
