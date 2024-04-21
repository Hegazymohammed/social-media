package com.example.endpoints.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.endpoints.dto.user.ShowAllUserDt;
import com.example.endpoints.dto.user.ShowAllUserDto;
import com.example.endpoints.dto.user.ShowUserDto;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserFollower;

public   interface userFollowerRepository extends JpaRepository<UserFollower, Integer> {
	
	  @Query("DELETE  FROM UserFollower uf  WHERE uf.targetId.Id=:targetId")
	  void deleteFollower(int targetId) ;
		// TODO Auto-generated method stub
	  @Query("""
	  		
	  		 SELECT new com.example.endpoints.dto.user.ShowUserDto(uf.getId(),uf.getFirstName(),
	  		 uf.getMiddleName(),uf.getLastName(),uf.getUserName() ,
	  		 uf.getEmail(),uf.getMobile(),uf.getRegisteredAt(),uf.getLastLogin(), 
	  		 uf.getIntro(),uf.getProfile())
	  		 FROM UserFollower uf WHERE targetId.id=:followerId
	  		 
	  		 
	  		 """)
	  
	  Optional<ShowUserDto>findFollowerById(int followerId);
	 
	  @Query("""
				select new com.example.endpoints.dto.user.ShowAllUserDto
				(u.targetId.id,u.targetId.firstName,u.targetId.middleName,u.targetId.lastName)
				 from UserFollower u where u.sourceId.id=:id
				""")
		List<ShowAllUserDto>findAllUsers(int id);
}
