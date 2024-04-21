package com.example.endpoints.service.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endpoints.dto.user.CreateUserDto;
import com.example.endpoints.dto.user.ShowAllUserDt;
import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.UserDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.exceptions.UserAlreadyExistException;
import com.example.endpoints.exceptions.UserNotFoundException;
import com.example.endpoints.mapper.UserMapper;
import com.example.endpoints.repository.UserRepository;
import com.example.endpoints.service.contract.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public void save( CreateUserDto user) {
		 Optional<User>opUser=	userRepository.findUserByUsername(user.username());
		 if(opUser.isPresent()) 
			 throw new UserAlreadyExistException("This User is already exist");
		 userRepository.save(UserMapper.user(user));
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 
			userRepository.deleteById(id);

	}

	@Override
	public Optional<UserDto> findById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user=userRepository.findById(id);
				 
		return Optional.of(user.map(UserMapper::dto)).orElseThrow(()->new UserNotFoundException("This user doesn't exist"));
	}

	@Override
	public List<ShowAllUserDto>findAll() {
		 return userRepository.findAllUsersDto();

	}

	@Override
	public Optional<UserDto> findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		Optional<User>user=userRepository.findUserByUsername(userName);
		return Optional.of(user.map(UserMapper::dto)).orElseThrow(()->new UserNotFoundException("this User doesn't exist") );
	}

}
