package com.example.endpoints.service.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endpoints.dto.usermessage.CreateUserMessageDto;
import com.example.endpoints.dto.usermessage.DeleteMessageDto;
import com.example.endpoints.dto.usermessage.UserMessageDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserMessage;
import com.example.endpoints.exceptions.UserNotFoundException;
import com.example.endpoints.mapper.UserMessageMapper;
import com.example.endpoints.repository.UserMessageRepository;
import com.example.endpoints.repository.UserRepository;
import com.example.endpoints.service.contract.UserMessageService;

 
@Service
public class UserMessageServiceImpl implements UserMessageService {

	private final  UserMessageRepository userMessageRepository;
	private final UserRepository userRepository;
	java.util.logging.Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	public UserMessageServiceImpl(UserMessageRepository userMessageRepository, UserRepository userRepository) {
	 
		this.userMessageRepository = userMessageRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void addMessage(CreateUserMessageDto dto) {
		// TODO Auto-generated method stub
		System.out.println("SenderId "+dto.getUserId());
		System.out.println("ReciverId "+dto.getReciverId());
		User senderId=userRepository.findById(dto.getUserId()).orElseThrow(()->new UserNotFoundException("Sender doesn't exist"));
		User reciverId=userRepository.findById(dto.getReciverId()).orElseThrow(()->new UserNotFoundException("Reciver doesn't exist"));
		UserMessage message=UserMessageMapper.message(dto);
		message.setSourceId(senderId);
		message.setTargetId(reciverId);
		System.out.println(message);
		userMessageRepository.save(message);
		
		
	}

	@Override
	public UserMessageDto updateMessage(UserMessageDto dto) {
		User senderId=userRepository.findById(dto.getUserId()).orElseThrow(()->new UserNotFoundException("User doesn't exist"));
		User reciverId=userRepository.findById(dto.getReciverId()).orElseThrow(()->new UserNotFoundException("User doesn't exist"));
		UserMessage message=UserMessageMapper.message(dto,LocalDateTime.now());
		message.setSourceId(senderId);
		message.setTargetId(reciverId);
		userMessageRepository.save(message);
		
		// TODO Auto-generated method stub
		return UserMessageMapper.dto(message);
	}

	@Override
	public UserMessageDto findMessageById(int messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMessage(DeleteMessageDto messageId) {
		// TODO Auto-generated method stub
		User sender=userRepository.findById(messageId.getSenderId()).orElseThrow(()->new UserNotFoundException("User doesn't exist"));
		User reciver=userRepository.findById(messageId.getReciverId()).orElseThrow(()->new UserNotFoundException("User doesn't exist"));
		if(sender.getId()!=messageId.getId()||messageId.getReciverId()!=reciver.getId())
			return false;
		userMessageRepository.deleteById(messageId.getId());
		return true;
		
		
	}
 
	@Override
	public boolean deleteMessageForAll(DeleteMessageDto messageId) {
		// TODO Auto-generated method stub
		 
		boolean senderMessage= deleteMessage(messageId);
		 int sender=messageId.getReciverId();
		 int reciver=messageId.getSenderId();
		 messageId.setReciverId(reciver);
		 messageId.setSenderId(sender);
		 boolean reciverMessage= deleteMessage(messageId);
		return senderMessage||reciverMessage;
		
		
	}

	@Override
	public List<UserMessageDto> findAll() {
		// TODO Auto-generated method stub
		return userMessageRepository.findAll().stream().map(UserMessageMapper::dto).toList();
	}
 
}
