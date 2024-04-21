package com.example.endpoints.mapper;

import java.time.LocalDateTime;

import com.example.endpoints.dto.usermessage.CreateUserMessageDto;
import com.example.endpoints.dto.usermessage.UserMessageDto;
import com.example.endpoints.entities.user.UserMessage;

public class UserMessageMapper {

	public static UserMessage message(CreateUserMessageDto dto) {
			LocalDateTime creation=LocalDateTime.now();
			UserMessage message=new UserMessage();
			message.setCreatedAt(creation);
			message.setUpdatedAt(creation);
			message.setMessage(dto.getMessage());
		 
			return message;
	}
	public static UserMessage message(UserMessageDto dto,LocalDateTime updated) {
		 
		UserMessage message=new UserMessage();
		 
		message.setUpdatedAt(updated);
		message.setMessage(dto.getMessage());
	 
		return message;
}
	public static UserMessageDto dto(UserMessage message) {
		// TODO Auto-generated method stub
		UserMessageDto dto=new UserMessageDto(message.getId(),message.getSourceId().getId(),message.getTargetId().getId()
				,message.getMessage(),message.getCreatedAt(),message.getUpdatedAt());
		return dto;
	}
}
