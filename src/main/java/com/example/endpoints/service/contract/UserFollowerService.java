package com.example.endpoints.service.contract;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.endpoints.dto.useFollower.UserFollowerDto;
import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.ShowUserDto;
import com.example.endpoints.dto.userFriend.UserFriendDto;
import com.example.endpoints.repository.UserRepository;

 
public interface UserFollowerService {
	
	ShowUserDto save(int sourceId,int targetId);
	ShowUserDto findUserById(int usreId,int followerId)	;
	List<ShowAllUserDto>findAll(int sourceId);
	void deleteUserFollower(int targetId);
	
	

}
