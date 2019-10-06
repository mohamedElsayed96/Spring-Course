package com.microservices.demo.DOA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
