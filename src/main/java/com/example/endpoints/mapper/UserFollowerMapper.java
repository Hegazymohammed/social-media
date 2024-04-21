package com.example.endpoints.mapper;

import com.example.endpoints.dto.useFollower.UserFollowerDto;
import com.example.endpoints.dto.user.ShowUserDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserFollower;

public class UserFollowerMapper {

	public static ShowUserDto UserFollowerDto(User follow) {
		// TODO Auto-generated method stub
		return new ShowUserDto(follow.getId(),follow.getFirstName(), follow.getMiddleName(),follow.getLastName(),
				follow.getLastName(), follow.getUsername(), follow.getMobile(), 
				follow.getRegisteredAt(), follow.getLastLogin(), follow.getIntro(), follow.getProfile());
	}
	
	public static User user(ShowUserDto user) {
		return User.builder().id(user.id()).firstName(user.firstName()).lastName(user.lastName())
					.middleName(user.middleName()).lastLogin(user.lastLogin()).registeredAt(user.registeredAt()).email(user.email()).build();
	}

	 
}
