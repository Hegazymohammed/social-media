package com.example.endpoints.mapper;

import java.time.LocalDateTime;

import com.example.endpoints.dto.user.ShowUserDto;
import com.example.endpoints.dto.userFriend.CreateUserFriendDto;
import com.example.endpoints.dto.userFriend.UserFriendDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserFriend;

public class UserFriendMapper {

	public static UserFriend userFriend(CreateUserFriendDto friend) {
		// TODO Auto-generated method stub
		LocalDateTime cration=LocalDateTime.now();
		UserFriend realtion=new UserFriend();
		realtion.setUpdatedAt(cration);
		realtion.setCreatedAt(cration);
		realtion.setNotes(friend.notes());
		realtion.setStatus(0);
		 
		return realtion;
	}

	
	 

}
