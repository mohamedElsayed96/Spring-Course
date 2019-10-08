package com.mohamedelsayed.springaop.service;

import java.util.List;

public interface Service<T, U> {

	public List<T> findAll();
	public T findById(U id);
	public void save(T ob);
	public void deleteById(U id);

}
