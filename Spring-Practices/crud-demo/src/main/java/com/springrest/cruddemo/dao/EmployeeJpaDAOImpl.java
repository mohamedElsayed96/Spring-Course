package com.springrest.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrest.cruddemo.entity.Employee;

@Repository
public class EmployeeJpaDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	@Autowired
	public EmployeeJpaDAOImpl(EntityManager entityManaget) {
		this.entityManager = entityManaget;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Query theQuery = entityManager.createQuery("FROM Employee", Employee.class);
		
		
		return theQuery.getResultList();
	}

	@Override
	public Employee find(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, id);
	}

	@Override
	public int Add(Employee emp) {
		// TODO Auto-generated method stub
		Employee em = entityManager.merge(emp);
		emp.setId(em.getId());
		return emp.getId();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Query theQuerty = entityManager.createQuery("delete from Employee where id=:empid");
		theQuerty.setParameter("empid", id);
		theQuerty.executeUpdate();
	}

}
