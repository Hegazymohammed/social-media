package com.example.endpoints.service.contract;

import java.util.List;
import java.util.Optional;

import com.example.endpoints.dto.user.CreateUserDto;
import com.example.endpoints.dto.user.ShowAllUserDt;
import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.UserDto;

public interface UserService {
	 
	void save(CreateUserDto user);
	void delete(int id);
	Optional<UserDto> findById(int id);
	List<ShowAllUserDto> findAll( );
	Optional<UserDto>findUserByUserName(String userName);
	
}
