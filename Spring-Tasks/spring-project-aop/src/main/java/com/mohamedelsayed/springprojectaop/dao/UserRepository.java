package com.mohamedelsayed.springprojectaop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mohamedelsayed.springprojectaop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	Void deleteByUsername(String username);
   
}
