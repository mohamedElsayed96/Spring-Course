package com.mohamedelsayed.springprojectaop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mohamedelsayed.springprojectaop.dao.UserRepository;
import com.mohamedelsayed.springprojectaop.dto.UserDto;
import com.mohamedelsayed.springprojectaop.entity.User;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
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
		Optional<User> user=  userRepository.findById(id);
		return user.isPresent()? user.get().Convert() : null ;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void save(UserDto user)  {
		userRepository.save(user.mapDtoToEntity(passwordEncoder));
		
	}


	@Override
	public UserDto findByUsername(String username) {
		// TODO Auto-generated method stub
		return  userRepository.findByUsername(username).Convert();
		//return user.isPresent()? user.get().Convert() : null ;
	}

}
