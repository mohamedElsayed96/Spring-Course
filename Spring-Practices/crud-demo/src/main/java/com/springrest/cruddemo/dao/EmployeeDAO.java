package com.springrest.cruddemo.dao;

import java.util.List;

import com.springrest.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	public Employee find(int id);
	public int Add(Employee emp);
	public void delete(int id);




}
