package com.microservices.demo.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservices.demo.DOA.PostRepository;
import com.microservices.demo.DOA.UserRepository;
import com.microservices.demo.Entity.Post;
import com.microservices.demo.Entity.User;
import com.microservices.demo.exception.UserNotFoundException;


@RestController
@RequestMapping("/api/users/{userId}")
public class PostApi {
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/posts")
	public List<Post> getUserPosts(@PathVariable("userId") int id)
	{
		
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return user.get().getPosts();
		throw new UserNotFoundException("id-"+id);
		
		
	}
	
	@PostMapping("/posts")
	public ResponseEntity<Object> addPost(@PathVariable("userId") int userId, @RequestBody Post post)
	{
		System.out.println("userId = " + userId );
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) 
		{
			post.setUser(user.get());
			Post savedPost =  postRepository.save(post);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedPost.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
		else
			throw new UserNotFoundException("id-"+userId);		
		
		
	}
	@GetMapping("/posts/{postId}")
	public Post getUserPosts(@PathVariable("userId") int id, @PathVariable("postId") int postId)
	{
		
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
			 Optional<Post> post =  postRepository.findById(postId);
			 if(post.isPresent())
				 return post.get();
			 throw new UserNotFoundException("id-"+postId);
		}
		throw new UserNotFoundException("id-"+id);
		
		
	}


}
