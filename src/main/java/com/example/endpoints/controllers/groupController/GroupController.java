package com.example.endpoints.controllers.groupController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.group.CreateGroupDto;
import com.example.endpoints.dto.group.ShowGroupResponseDto;
import com.example.endpoints.service.contract.GroupService;

@RestController
@RequestMapping(path="/group/")
public class GroupController {

	private final GroupService groupService;
	
   @Autowired
	public GroupController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}

 	@PostMapping("")
	ResponseEntity<CreateGroupDto> createGroup(@RequestBody CreateGroupDto group) {
 		System.out.println(group.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(groupService.save(group));
	}
	
 	@GetMapping("{id}")
	ResponseEntity<ShowGroupResponseDto>findById(@PathVariable(name="id") int groupId){
		
			ShowGroupResponseDto group=groupService.findById(groupId);
			return ResponseEntity.status(HttpStatus.CREATED).body(group);
	}
	
}
