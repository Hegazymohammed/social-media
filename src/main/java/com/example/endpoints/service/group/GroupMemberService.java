package com.example.endpoints.service.group;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endpoints.entities.group.Group;
import com.example.endpoints.entities.group.GroupMember;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.exceptions.GroupNotFoundException;
import com.example.endpoints.exceptions.UserNotFoundException;
import com.example.endpoints.repository.GroupMemberRepository;
import com.example.endpoints.repository.GroupRepository;
import com.example.endpoints.repository.UserRepository;

@Service
public class GroupMemberService {
	
	private final UserRepository userRepository;
	private final GroupRepository groupRepository;
	private final GroupMemberRepository groupMemberRepository;
	
	@Autowired
	public GroupMemberService(UserRepository userRepository, GroupRepository groupRepository,
			GroupMemberRepository groupMemberRepository) {
		super();
		this.userRepository = userRepository;
		this.groupRepository = groupRepository;
		this.groupMemberRepository = groupMemberRepository;
	}


	public void AddUserToTheGroup(int userId,int groupId) {
		 User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("this User doesn't exist"));
		 Group group=groupRepository.findById(groupId).orElseThrow(()->new GroupNotFoundException("this group doesn't exist"));
		 GroupMember member=new GroupMember();
		 LocalDateTime creation=LocalDateTime.now();
		 member.setCreatedAt(creation);
		 member.setUpdatedAt(creation);
		 member.setUserId(user);
		 member.setGroupId(group);
		 member.setStatus(1);
		 groupMemberRepository.save(member);
		 
	}
}
