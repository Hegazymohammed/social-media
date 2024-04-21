package com.example.endpoints.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.endpoints.dto.user.ShowAllUserDt;
import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.UserDto;
import com.example.endpoints.entities.user.User;

public   interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User>findUserByUsername(String username); 
	
	@Query("""
			select new com.example.endpoints.dto.user.ShowAllUserDto(u.id,u.firstName,u.middleName,u.lastName) from User u
			""")
	List<ShowAllUserDto>findAllUsersDto();
	

}
