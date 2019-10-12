package com.mohamedelsayed.springprojectaop.service;

import java.util.List;

public interface EntityService<T, U> {

	public List<T> findAll();
	public T findById(U id);
	public void save(T ob);
	public void deleteById(U id);

}
