package com.example.endpoints.mapper;

import java.time.LocalDateTime;

import com.example.endpoints.dto.userpost.UserPostDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserPost;

public class UserPostMapper {
 
	public static UserPost post( UserPostDto  post ) {
		LocalDateTime creation=LocalDateTime.now();
		return new UserPost(  post.getMessage(),creation,creation);
		
	}
	
	public static UserPostDto userPostDto(UserPost post) {
		return new  UserPostDto(post.getId(),post.getUserId().getId(),
				post.getSenderId().getId(),post.getMessage(),post.getCreatedAt(),post.getUpdatedAt());
	}
}
