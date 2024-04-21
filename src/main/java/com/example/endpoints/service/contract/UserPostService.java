package com.example.endpoints.service.contract;

import java.util.List;
import java.util.Optional;

import com.example.endpoints.dto.userpost.UserPostDto;
import com.example.endpoints.dto.userpost.sharePostDto;
import com.example.endpoints.entities.user.UserPost;

public interface UserPostService {

	void addPost(UserPostDto post);
	void  deletePost(int userId,int postId);
	Optional<UserPost> findPost(int postId);
	UserPostDto updatePost(UserPostDto post);
	 
	List<UserPostDto> findUserAllPostsByUserId(int userId);
	 UserPostDto findUserPostByPostIdAndUserId(int userId,int postId);
	UserPostDto sharePost(sharePostDto dto);
	
}
