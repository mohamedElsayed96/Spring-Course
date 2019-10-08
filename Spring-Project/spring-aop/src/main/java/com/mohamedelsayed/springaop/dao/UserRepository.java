package com.mohamedelsayed.springaop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mohamedelsayed.springaop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
   @Query(value = "select * from user where u.username=?1", nativeQuery = true)
	Optional<User> findByUsername(String username);
   
}
