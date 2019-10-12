package com.mohamedelsayed.springprojectaop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedelsayed.springprojectaop.dao.UserRepository;
import com.mohamedelsayed.springprojectaop.dto.UserDto;
import com.mohamedelsayed.springprojectaop.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository UserRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		UserRepository = userRepository;
	}


	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		List<User> users = UserRepository.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for(User user : users) 
		{
			userDtos.add(user.Convert());
		}
		return userDtos;
	}

	
	@Override
	public UserDto findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> user=  UserRepository.findById(id);
		return user.isPresent()? user.get().Convert() : null ;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void save(UserDto user) {
		
		
	}


	@Override
	public UserDto findByUsername(String username) {
		// TODO Auto-generated method stub
		return  UserRepository.findByUsername(username).Convert();
		//return user.isPresent()? user.get().Convert() : null ;
	}

}
