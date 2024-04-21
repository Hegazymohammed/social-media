package com.example.endpoints.mapper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import com.example.endpoints.dto.user.CreateUserDto;
import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.ShowUserDto;
import com.example.endpoints.dto.user.UserDto;
import com.example.endpoints.entities.user.User;

public class UserMapper {
	
	public  static  UserDto dto(User user) {
		 return new UserDto(user.getId(),user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getUsername() );
	}
	
	public static  User user(CreateUserDto user) {
		
		   String password=null;
		return new User( user.firstName(),user.middleName(),user.lastName(),
			   user.mobile(),user.email(), user.username(),bycryptPassword(user.password()),
			   LocalDateTime.now(),LocalDateTime.now(),null,null);
	}
	private static String bycryptPassword(String password) {
		StringBuilder builder=new StringBuilder();
		try {
			MessageDigest  md=MessageDigest.getInstance("SHA-512");
			byte[]digested=md.digest(password.getBytes());
			for(int i=0;i<digested.length;++i) {
				builder.append(Integer.toHexString(0xFF&digested[i]));
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Bad algorithim");
			
		}
		return builder.toString();
	}
	
	public static ShowAllUserDto showAllUserDto(User user) {
		/*
 			private int id; 
	private String firstName;
	private String middleName;
	private String lastName;
		 */
		  ShowAllUserDto dto=new ShowAllUserDto(user.getId(),user.getFirstName(),user.getMiddleName(),user.getLastName()	);
		  return dto;
	}
}
