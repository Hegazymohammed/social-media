package com.example.endpoints.dto.userFriend;

import java.time.LocalDateTime;

import com.example.endpoints.entities.user.User;

 
 
public record UserFriendDto  (
	 int id,
	 int sourceId,
	 int targetId,
     int status
	) {
	 
}
