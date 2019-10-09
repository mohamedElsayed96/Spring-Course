package com.mohamedelsayed.springprojectaop.service;

import com.mohamedelsayed.springprojectaop.dao.UserRepository;
import com.mohamedelsayed.springprojectaop.dto.UserDto;


public interface UserService extends Service<UserDto, Integer> {

	public UserDto findByUsername(String username);
}
