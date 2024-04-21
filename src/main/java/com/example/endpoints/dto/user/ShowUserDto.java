package com.example.endpoints.dto.user;

import java.time.LocalDateTime;
import java.util.List;


@lombok.Builder 
public record ShowUserDto (
 
	 int id, 
	 String firstName,
	 String middleName,
	 String lastName,
	 String username,
	 String email,
	 String mobile,
	 
	 LocalDateTime registeredAt,
	 LocalDateTime lastLogin,
	 String intro,
	 String profile
	  
 	
 ) {

	 
}
