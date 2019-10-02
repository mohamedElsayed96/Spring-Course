package com.springrest.cruddemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.springrest.cruddemo.entity.Employee;
import com.springrest.cruddemo.service.EmployeeService;

@RestController
public class EmployeeApi {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeApi(EmployeeService employedDAO) {
		this.employeeService = employedDAO;
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee find(@PathVariable("id") int id) 
	{
		return employeeService.findById(id);
	}
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) 
	{
		employeeService.save(emp);
		return emp;
	}
	@PutMapping("/addEmployee")
	public Employee updateEmployee(@RequestBody Employee emp) 
	{
		employeeService.save(emp);
		return emp;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public String  deleteEmployee(@PathVariable("id") int id)
	{
		Employee emp = employeeService.findById(id);
		if(emp != null) 
		{
			employeeService.deleteById(id);
			return "Entity with Id " + id + "is deleted";
		}
		
		return "This id doesn't exist";
		
	}

}
