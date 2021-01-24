package com.hitaek.springboot.crudepractice.service;

import java.util.List;

import com.hitaek.springboot.crudepractice.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
