package com.example.endpoints.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserFriend;

public   interface userFriendRepository extends JpaRepository<UserFriend, Integer> {
	@Query("select u.targetId from UserFriend u where u.sourceId.id=:id")
	ArrayList<User>findUserFriendebyId(int id);
	
	 @Query("SELECT uf.targetId FROM UserFriend uf WHERE uf.sourceId.id = :sourceId")
	    List<User> findAllUsersFriendsByUserId(int sourceId);
	 @Query("select uf.targetId from UserFriend uf where uf.sourceId.id=:sourceId and uf.targetId.id=:targetId")
	 Optional<User>findUserFriendByUserId(int sourceId,int targetId);

}
