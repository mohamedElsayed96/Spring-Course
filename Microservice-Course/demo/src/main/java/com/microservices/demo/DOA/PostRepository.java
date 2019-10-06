package com.microservices.demo.DOA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.demo.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
