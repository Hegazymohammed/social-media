package com.example.endpoints.service.contract;

import java.util.List;

import com.example.endpoints.dto.usermessage.CreateUserMessageDto;
import com.example.endpoints.dto.usermessage.DeleteMessageDto;
import com.example.endpoints.dto.usermessage.UserMessageDto;

public interface UserMessageService {

	void addMessage(CreateUserMessageDto dto);
	UserMessageDto updateMessage(UserMessageDto dto);
	UserMessageDto findMessageById(int messageId);
	boolean deleteMessage (DeleteMessageDto message);
	boolean deleteMessageForAll(DeleteMessageDto message);
	List<UserMessageDto>findAll();
	
}
