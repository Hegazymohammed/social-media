package com.example.endpoints.dto.userpost;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserPostDto {
  
	private int id;
	private int userId;
	private int senderId;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public UserPostDto(  int userId, int senderId, String message) {
		 
		 
		this.userId = userId;
		this.senderId = senderId;
		this.message = message;
	}
	
}
