package com.example.endpoints.service.contract;

import java.util.List;
import java.util.Optional;

import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.UserDto;

public interface UserFriendService {
	
	 

	 Optional<UserDto> findUserFriendById(int userId,int friendId);
	 
	 List<ShowAllUserDto>findAllUsersFriends(int source);

}
