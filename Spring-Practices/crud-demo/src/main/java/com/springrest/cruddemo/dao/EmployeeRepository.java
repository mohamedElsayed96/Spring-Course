package com.springrest.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
