package com.example.endpoints.controllers.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.usermessage.CreateUserMessageDto;
import com.example.endpoints.dto.usermessage.DeleteMessageDto;
import com.example.endpoints.dto.usermessage.UserMessageDto;
import com.example.endpoints.service.contract.UserMessageService;

@RestController
@RequestMapping(path="/message/")
public class UserMessageController {
	
	private  final UserMessageService userMessageService;
	
	
 
	@Autowired
	public UserMessageController(UserMessageService userMessageService) {
		super();
		this.userMessageService = userMessageService;
	}

	@PostMapping("")
	ResponseEntity  CreateUserMessage(@RequestBody CreateUserMessageDto userMessage) {
		System.out.println(userMessage);
		userMessageService.addMessage(userMessage);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PostMapping("/update")
	ResponseEntity<UserMessageDto> UpdateUserMessage(@RequestBody UserMessageDto userMessage) {
		UserMessageDto updatedMessage= userMessageService.updateMessage(userMessage);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedMessage);
	}
	@PostMapping("sender/")
	ResponseEntity deleteMessageForSender(@RequestBody DeleteMessageDto dto) {
		boolean deleteMessageForUsre=userMessageService.deleteMessage(dto);
		return ResponseEntity.status(deleteMessageForUsre==true?HttpStatus.OK:HttpStatus.FORBIDDEN).build();
	}
 
	@PostMapping("all/")
	ResponseEntity deleteMessageForAll(@RequestBody DeleteMessageDto dto) {
		boolean deleteMessageForUsre=userMessageService.deleteMessageForAll(dto);
		return ResponseEntity.status(deleteMessageForUsre==true?HttpStatus.OK:HttpStatus.FORBIDDEN).build();
	}
	

	@GetMapping("")
	List<UserMessageDto>findAll(){
		return userMessageService.findAll();
	}
}
