package com.example.endpoints.controllers.userController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.userpost.UserPostDto;
import com.example.endpoints.dto.userpost.sharePostDto;
import com.example.endpoints.service.contract.UserPostService;

@RestController
@RequestMapping(path = "/post/")
public class UserPostController {

	private final UserPostService userPost;

	public UserPostController(UserPostService userPost) {
		super();
		this.userPost = userPost;
	}
	
	@GetMapping("{id}")
	List<UserPostDto> findAllUserPostByUserId(@PathVariable int id) {
		
		return userPost.findUserAllPostsByUserId(id);
		
	}
	@GetMapping("{userId}/{postId}")
	UserPostDto findUserPostByPostIdAndUserId( @PathVariable int userId,@PathVariable int postId) {
		 return userPost.findUserPostByPostIdAndUserId(userId,postId);
	}
	
	@PostMapping("create")
	ResponseEntity createUserPost( @RequestBody UserPostDto post) {
		 userPost.addPost(post);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("")
	ResponseEntity<UserPostDto> updateUserPost( @RequestBody UserPostDto post) {
		UserPostDto updatedPost= userPost.updatePost(post);
		 return ResponseEntity.status(HttpStatus.CREATED).body(updatedPost);
	}
	@DeleteMapping("{userId}/{postId}")
	void  deteteUserPost(@PathVariable int userId,int postId) {
		 userPost.deletePost(userId, postId);
	}
	
	//usershare post
	@PostMapping()
	ResponseEntity<UserPostDto> sharePost(@PathVariable sharePostDto dto) {
								UserPostDto post=userPost.sharePost(dto);
								return ResponseEntity.status(HttpStatus.CREATED	).body(post);
		
	}
}
