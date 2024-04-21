package com.example.endpoints.dto.usermessage;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserMessageDto {
	private int id;
	private int userId;
	private int reciverId;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
