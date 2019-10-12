package com.mohamedelsayed.springprojectaop.service;

import com.mohamedelsayed.springprojectaop.dto.UserDetails;


public interface UserDetailsService {
	public UserDetails findByUsername(String username);
}

