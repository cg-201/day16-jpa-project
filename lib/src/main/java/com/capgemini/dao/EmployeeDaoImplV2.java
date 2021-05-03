package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.capgemini.entities.Employee;
import com.capgemini.util.JPAUtil;

public class EmployeeDaoImplV2 implements EmployeeDao {
	
	private EntityManager manager;
	
	public EmployeeDaoImplV2() {
		manager = JPAUtil.getEntityManager();
	}
	

	@Override
	public boolean createEmployee(Employee employee) {
		
		manager.getTransaction().begin();
		manager.persist(employee);
		manager.getTransaction().commit();
		
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		// find then udpate
		Employee oldEmployee = manager.find(Employee.class, employee.getId());
		
		// update
		oldEmployee.setName(employee.getName());
		oldEmployee.setEmail(employee.getEmail());
		oldEmployee.setSalary(employee.getSalary());
		
		// txn
		manager.getTransaction().begin();
		manager.merge(oldEmployee);
		manager.getTransaction().commit();
		
		return true;
		
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// find then delete
		Employee oldEmployee = manager.find(Employee.class, employee.getId());
		
		// txn
		manager.getTransaction().begin();
		manager.remove(oldEmployee);
		manager.getTransaction().commit();
		
		return true;
	}

	@Override
	public Employee findById(int id) {
		
		return manager.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		return null;
	}

}
