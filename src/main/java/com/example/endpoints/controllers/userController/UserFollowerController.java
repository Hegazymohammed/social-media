package com.example.endpoints.controllers.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.ShowUserDto;
import com.example.endpoints.service.contract.UserFollowerService;

@RestController
@RequestMapping(path="/userFollower/")
public class UserFollowerController {
	//show all follower id username
	//show specifice follower by id
	//add new follower
	//delete follower
	private final UserFollowerService userFollowerService;
	@Autowired
	public UserFollowerController(UserFollowerService userFollowerService) {
		super();
		this.userFollowerService = userFollowerService;
	}

	@GetMapping("{userId}/{targetId}")
	ResponseEntity addFollower(@PathVariable int userId,@PathVariable int targetId) {
		userFollowerService.save(userId,targetId);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@DeleteMapping("{targetId}")
	void deleteFollower(int targetId) {
		 userFollowerService.deleteUserFollower(targetId);
		 
	}
	@GetMapping("userId/{sourceId}")
	List<ShowAllUserDto>findAll(@PathVariable int sourceId){
		return userFollowerService.findAll(sourceId);
	}
	@GetMapping("/{userId}/follower/{targetId}")
	ResponseEntity<ShowUserDto >findById(int source,int target) {
		return ResponseEntity.status(HttpStatus.OK).body(userFollowerService.findUserById(source,target));
	}
}
