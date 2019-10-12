package com.mohamedelsayed.springprojectaop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedelsayed.springprojectaop.dao.UserRepository;
import com.mohamedelsayed.springprojectaop.dto.UserDetails;
import com.mohamedelsayed.springprojectaop.entity.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails findByUsername(String username) {
		// TODO Auto-generated method stub
		User user=  userRepository.findByUsername(username);
		return user!=null? new UserDetails(user.getUsername(), user.getPassword()) : null ;
	}

}
