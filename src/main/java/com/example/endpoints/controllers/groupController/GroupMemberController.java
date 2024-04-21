package com.example.endpoints.controllers.groupController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.service.group.GroupMemberService;

@RestController
@RequestMapping(path="/group/member/")
public class GroupMemberController {
	
	private  final GroupMemberService groupMemberService;
	
	public GroupMemberController(GroupMemberService groupMemberService) {
		super();
		this.groupMemberService = groupMemberService;
	}

	@GetMapping("{groupId}/{userId}")
	public void addUserToTheGroup(@PathVariable int groupId,@PathVariable int userId) {
			  groupMemberService.AddUserToTheGroup(userId, groupId);
	}
}
