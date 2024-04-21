package com.example.endpoints.service.group;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endpoints.dto.group.CreateGroupPostDto;
import com.example.endpoints.dto.group.ShowPostDto;
import com.example.endpoints.dto.userpost.UserPostDto;
import com.example.endpoints.entities.group.Group;
import com.example.endpoints.entities.group.GroupPost;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.exceptions.GroupNotFoundException;
import com.example.endpoints.exceptions.UserNotFoundException;
import com.example.endpoints.repository.GroupPostRepository;
import com.example.endpoints.repository.GroupRepository;
import com.example.endpoints.repository.UserRepository;

@Service
public class GroupPostService {

	private final GroupRepository groupRepository;
	private final GroupPostRepository groupPostRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public GroupPostService(GroupRepository groupRepository, GroupPostRepository groupPostRepository,UserRepository userRepository) {
 
		this.groupRepository = groupRepository;
		this.groupPostRepository = groupPostRepository;
		this.userRepository=userRepository;
	}


	public CreateGroupPostDto save(int groupId,CreateGroupPostDto pos) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(pos.getUserId()).orElseThrow(()->new UserNotFoundException("User doesn't exist"));
		Group  Group=groupRepository.findById(groupId).orElseThrow(()->new GroupNotFoundException("User doesn't exist"));
		GroupPost post=new GroupPost();
		LocalDateTime creation=LocalDateTime.now();
		post.setCreatedAt(creation);
		post.setUpdatedAt(creation)	;
		post.setGroupId(Group);
		post.setMessage(pos.getMessage());
		post.setUserId(user);
		groupPostRepository.save(post);
		return new CreateGroupPostDto(user.getId(),pos.getMessage(),creation);
	}

}
