package com.mohamedelsayed.springprojectaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedelsayed.springprojectaop.dao.UserRepository;
import com.mohamedelsayed.springprojectaop.dto.RegisterDTO;

@Service
public class RegiseterServiceImpl implements RegisterService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public void Register(RegisterDTO register) {
		// TODO Auto-generated method stub
		userRepository.save(register.mapDtoToEntity());
	}

}
