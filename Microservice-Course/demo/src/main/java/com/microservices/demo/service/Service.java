package com.microservices.demo.service;

import java.util.List;

public interface Service<T> {
	public List<T> findAll();
	public T findById(int id);
	public T Save(T user);
	public void delete(int Id);

}
