package com.example.endpoints.dto.userFriend;

import java.time.LocalDateTime;
 
 
public record CreateUserFriendDto (
	 int sourceId,
	 int targetId,
 
	
	 int status,
	 LocalDateTime createdAt,
	 LocalDateTime updatedAt,
	 String notes
	) {
}
