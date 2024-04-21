package com.example.endpoints.controllers.groupController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.group.CreateGroupPostDto;
import com.example.endpoints.dto.group.ShowPostDto;
import com.example.endpoints.dto.userpost.UserPostDto;
import com.example.endpoints.service.group.GroupPostService;

@RestController
@RequestMapping(path="/group/post")
public class GroupPostController {

	private final GroupPostService  groupPostService;
	
	@Autowired
	public GroupPostController(GroupPostService groupPostService) {
		super();
		this.groupPostService = groupPostService;
	}
	
	@PostMapping("/{groupId}")
	public  ResponseEntity<CreateGroupPostDto > addPostToTheGroup(@PathVariable int groupId ,@RequestBody CreateGroupPostDto pos) {
		CreateGroupPostDto  responsePost=groupPostService.save(  groupId,pos);
		   
		   return ResponseEntity.status(HttpStatus.CREATED).body(responsePost);
	}
	
}
