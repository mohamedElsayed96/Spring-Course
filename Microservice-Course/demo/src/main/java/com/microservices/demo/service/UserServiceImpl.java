package com.microservices.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.demo.DOA.UserRepository;
import com.microservices.demo.Entity.User;
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		Optional<User> us = userRepository.findById(id);
		if(us.isPresent())
			return us.get();
		
		
		return null;
	}

	@Override
	public User Save(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(Id);
		
	}

}
