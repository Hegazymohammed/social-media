package com.example.endpoints.service.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endpoints.dto.user.ShowAllUserDt;
import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.ShowUserDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserFollower;
import com.example.endpoints.exceptions.UserNotFoundException;
import com.example.endpoints.mapper.UserFollowerMapper;
import com.example.endpoints.repository.UserRepository;
import com.example.endpoints.repository.userFollowerRepository;
import com.example.endpoints.service.contract.UserFollowerService;

@Service
public class UserFollowerServiceImpl implements UserFollowerService {
	private final UserRepository userRepository;
	private final userFollowerRepository userFollower;
	
	@Autowired
	
	public UserFollowerServiceImpl(UserRepository userRepository, userFollowerRepository userFollower) {
		super();
		this.userRepository = userRepository;
		this.userFollower = userFollower;
	}

	@Override
	public ShowUserDto save(int sourceId, int targetId) {
		// TODO Auto-generated method stub
		Optional<User> source=userRepository.findById(sourceId);
		Optional<User>target=userRepository.findById(targetId);
		if(source.isEmpty()||target.isEmpty())
			throw new UserNotFoundException("This user is not exist");
		
		UserFollower follow=new UserFollower();
		follow.setSourceId(source.get());
		follow.setTargetId(target.get());
		LocalDateTime creation=LocalDateTime.now();
		follow.setCreatedAt(creation);
		follow.setUpdatedAt(creation);
		userFollower.save(follow);
		return UserFollowerMapper.UserFollowerDto(follow.getTargetId());
	}

	@Override
	public ShowUserDto findUserById(int sourceId,int targetId) {
		// TODO Auto-generated method stub
	 
		Optional<User> source=userRepository.findById(sourceId);
		Optional<User>target=userRepository.findById(targetId);
	 
		if(source.isEmpty()||target.isEmpty())
			throw new UserNotFoundException("This user is not exist");
		 ShowUserDto follower=userFollower.findFollowerById(targetId).orElseThrow(()->new UserNotFoundException("This user does not exist"));
		return follower;
	}

	@Override
	public List<ShowAllUserDto> findAll(int sourceId) {
		// TODO Auto-generated method stub
	 
		 
		return userFollower.findAllUsers(sourceId);
	}

	@Override
	public void deleteUserFollower(int targetId) {
		// TODO Auto-generated method stub
		
		 userFollower.deleteFollower(targetId);
		
	}
	
	 

}
