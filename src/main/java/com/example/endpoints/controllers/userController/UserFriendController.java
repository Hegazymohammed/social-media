package com.example.endpoints.controllers.userController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.UserDto;
import com.example.endpoints.dto.userFriend.UserFriendDto;
import com.example.endpoints.service.contract.UserFriendService;

@RestController
@RequestMapping(path="/friend/")
public class UserFriendController {
	
	private final UserFriendService userFriendService;
	
	@Autowired
	public UserFriendController(UserFriendService userFriendService) {
	 
		this.userFriendService = userFriendService;
	}
	@GetMapping("userId/{userId}/friendId/{friendId}")
	public UserDto findFriendById(@PathVariable int userId,@PathVariable int friendId) {
			 Optional<UserDto>  friend= userFriendService.findUserFriendById(userId, friendId);
			 return friend.get();
	}
	@GetMapping("{userId}")
	public List<ShowAllUserDto> findAllUserFriend(@PathVariable int userId  ) {
			return userFriendService.findAllUsersFriends(userId);
	}
	
	
}
