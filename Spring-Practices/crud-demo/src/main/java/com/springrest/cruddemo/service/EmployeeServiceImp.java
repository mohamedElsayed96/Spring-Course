package com.springrest.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.cruddemo.dao.EmployeeRepository;
import com.springrest.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRepository emplRepository;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeDao) {
		this.emplRepository = employeeDao;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return emplRepository.findAll();
	}

	@Override

	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> empl = emplRepository.findById(id);
		if(empl.isPresent())
			return emplRepository.findById(id).get();
		else 
			return null; 
	}

	@Override
	
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return emplRepository.save(emp);
	}

	@Override
	
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		emplRepository.deleteById(id);
	}

}
