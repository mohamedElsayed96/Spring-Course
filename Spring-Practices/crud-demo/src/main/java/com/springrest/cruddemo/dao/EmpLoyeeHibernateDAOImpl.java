package com.springrest.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.cruddemo.entity.Employee;

@Repository
public class EmpLoyeeHibernateDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	@Autowired
	public EmpLoyeeHibernateDAOImpl(EntityManager entityManaget) {
		this.entityManager = entityManaget;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		
		return theQuery.getResultList();
	}
	@Override

	public Employee find(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class, id);
		return emp;
	}
	@Override
	public int Add(Employee emp) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
		return emp.getId();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Employee where id=:empId");
		theQuery.setParameter("empId", id);
		theQuery.executeUpdate();
		
	}
	

}
