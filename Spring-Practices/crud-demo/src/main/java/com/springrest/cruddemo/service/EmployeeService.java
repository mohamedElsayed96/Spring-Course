package com.springrest.cruddemo.service;
import java.util.List;

import com.springrest.cruddemo.entity.*;


public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public Employee save(Employee emp);
	public void deleteById(int id);
}
