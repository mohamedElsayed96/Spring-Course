package com.mohamedelsayed.springaop.service;

import com.mohamedelsayed.springaop.dao.UserRepository;
import com.mohamedelsayed.springaop.dto.UserDto;


public interface UserService extends Service<UserDto, Integer> {

	public UserDto findByUsername(String username);
}
