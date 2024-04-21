package com.example.endpoints.dto.userFriend;

import java.time.LocalDateTime;

import com.example.endpoints.dto.user.ShowUserDto;

 
public record ShowUserFriend (
     int targetId,
     int status,
	 LocalDateTime createdAt,
	 LocalDateTime updatedAt,
	 String notes
	 ){
	
}
