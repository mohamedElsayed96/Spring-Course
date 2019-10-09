package com.mohamedelsayed.springprojectaop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mohamedelsayed.springprojectaop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
   @Query(value = "select * from user where u.username=?1", nativeQuery = true)
	Optional<User> findByUsername(String username);
   
}
