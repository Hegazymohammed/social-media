package com.example.endpoints.dto.usermessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUserMessageDto {
 
	private int userId;
	private int reciverId;
	private String message;
	 
}
