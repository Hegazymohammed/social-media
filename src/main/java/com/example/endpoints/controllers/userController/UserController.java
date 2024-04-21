package com.example.endpoints.controllers.userController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.endpoints.dto.user.CreateUserDto;
import com.example.endpoints.dto.user.ShowAllUserDt;
import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.ShowUserDto;
import com.example.endpoints.dto.user.UserDto;
import com.example.endpoints.service.contract.UserService;
 

@RestController
@RequestMapping(path="/user/")
 
public class UserController {
	 
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("all")
	List<ShowAllUserDto>findAll(){
		return userService.findAll();
	}
	
	 
	@GetMapping("{id}")
	public ResponseEntity<UserDto> findUserId(@PathVariable int id) {
			Optional<UserDto>user=userService.findById(id);
		     ResponseEntity<UserDto>response=ResponseEntity.status(user.isPresent()?HttpStatus.FOUND:HttpStatus.NOT_FOUND).body(user.get());
		     return response;
	}
	
	@GetMapping("username/{username}")
	public ResponseEntity<UserDto> findUserByUserName(@PathVariable String username) {
			Optional<UserDto>user=userService.findUserByUserName(username);
		     ResponseEntity<UserDto>response=ResponseEntity.status(user.isPresent()?HttpStatus.FOUND:HttpStatus.NOT_FOUND).body(user.get());
		     return response;
	}
	
	@PostMapping("")
	//request
	public ResponseEntity<CreateUserDto>addUser(@RequestBody CreateUserDto user){
			 userService.save(user);
			 ResponseEntity<CreateUserDto>response=ResponseEntity.status(HttpStatus.CREATED).body(null);
			 return response;
	}
	@DeleteMapping("{id}")
	public  ResponseEntity deleteUser(@PathVariable int id	) {
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	 
}
