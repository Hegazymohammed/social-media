package com.example.endpoints.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.UserDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.mapper.UserMapper;
import com.example.endpoints.repository.UserRepository;
import com.example.endpoints.repository.userFriendRepository;
import com.example.endpoints.service.contract.UserFriendService;

@Service
public class UserFriendServiceImpl implements UserFriendService {
	
	private final UserRepository userRepository;
	private final userFriendRepository userFriendRepository;
	
	@Autowired
	public UserFriendServiceImpl(UserRepository userRepository,
			com.example.endpoints.repository.userFriendRepository userFriendRepository) {
		 
		this.userRepository = userRepository;
		this.userFriendRepository = userFriendRepository;
	}

	 

	@Override
	public List<ShowAllUserDto> findAllUsersFriends(int source) {
		// TODO Auto-generated method stub
		return userFriendRepository.findAllUsersFriendsByUserId(source).stream().map(UserMapper::showAllUserDto).toList();
	}



	@Override
	public Optional<UserDto> findUserFriendById(int userId, int friendId) {
		// TODO Auto-generated method stub
		Optional<User> friend=userFriendRepository.findUserFriendByUserId(userId, friendId);
		 if(friend.isEmpty())
			 return Optional.empty();
		return Optional.of(UserMapper.dto(friend.get()));
		 
	}


 

}
