package com.example.endpoints.service.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endpoints.dto.userpost.UserPostDto;
import com.example.endpoints.dto.userpost.sharePostDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserPost;
import com.example.endpoints.exceptions.IllegalUserException;
import com.example.endpoints.exceptions.PostNotFoundException;
import com.example.endpoints.exceptions.UserNotFoundException;
import com.example.endpoints.mapper.UserPostMapper;
import com.example.endpoints.repository.UserPostRepository;
import com.example.endpoints.repository.UserRepository;
import com.example.endpoints.service.contract.UserPostService;

@Service
public class UserPostServiceImpl implements  UserPostService {

	private final  UserPostRepository userPostRepository;
	private final UserRepository userRepository;
	@Autowired
	public UserPostServiceImpl(UserPostRepository userPostRepository, UserRepository userRepository) {
		super();
		this.userPostRepository = userPostRepository;
		this.userRepository = userRepository;
	}
	 
	@Override
	public void addPost(UserPostDto postDto) {
		// TODO Auto-generated method stub
		User userId=userRepository.findById(postDto.getUserId()).orElseThrow(()->new UserNotFoundException("This User doesn't exist"));
	    UserPost post=UserPostMapper.post(postDto);
	    post.setUserId(userId);
	    User senderId=userRepository.findById(postDto.getUserId()).orElseThrow(()->new UserNotFoundException("This User doesn't exist"));
	    post.setSenderId(senderId);
	    userPostRepository.save(post);
	}

 


	@Override
	public void deletePost(int userId,int postId) {
		// TODO Auto-generated method stub
		 UserPost post=userPostRepository.findById(postId).orElseThrow(()->new PostNotFoundException("This post doesn't exist"));
		 if(post.getUserId().getId()!=userId)
			 throw new IllegalUserException("This user doesn't belong to ");
	   userPostRepository.delete(post);
	}

	@Override
	public Optional<UserPost> findPost(int postId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public UserPostDto updatePost(UserPostDto postDto) {
		User userId=userRepository.findById(postDto.getUserId()).orElseThrow(()->new UserNotFoundException("This User doesn't exist"));
	    UserPost post1=UserPostMapper.post(postDto);
	    post1.setUserId(userId);
	    User senderId=userRepository.findById(postDto.getUserId()).orElseThrow(()->new UserNotFoundException("This User doesn't exist"));
	    post1.setSenderId(senderId);
	    post1.setUpdatedAt(LocalDateTime.now());
	    userPostRepository.save(post1);
	    return UserPostMapper.userPostDto(post1);
	}
 
	@Override
	public List<UserPostDto> findUserAllPostsByUserId(int userId) {
		// TODO Auto-generated method stub
		return  userPostRepository.findUserPostsByUserId(
				userId).stream().map(post-> UserPostMapper.userPostDto(post))
						.collect(Collectors.toList());
	}

	@Override
	public UserPostDto findUserPostByPostIdAndUserId(  int userId,int postId) {
		// TODO Auto-generated method stub
			UserPost userPost=userPostRepository.findUserPostByPostIdAndUserId(postId, userId).orElseThrow(()->new PostNotFoundException("This post is not valid"));
		return  UserPostMapper.userPostDto(userPost);
	}

	@Override
	public UserPostDto sharePost(sharePostDto dto) {
		// TODO Auto-generated method stub
		UserPost post=userPostRepository.findById(dto.getId()).orElseThrow(()->new PostNotFoundException("This post doesn't exist"));
		User user=userRepository.findById(dto.getSenderId()).orElseThrow(()->new UserNotFoundException("this user doesn't exist"));
		post.setSenderId(user);
		User sender=userRepository.findById(dto.getSenderId()).orElseThrow(()->new UserNotFoundException("this user doesn't exist"));
		userPostRepository.save(post);
		UserPost newPost=new UserPost(user,sender,post.getMessage(),post.getCreatedAt(),LocalDateTime.now());
		return UserPostMapper.userPostDto(post);
	}
	
	
 
	
 

}
