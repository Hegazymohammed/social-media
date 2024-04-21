package com.example.endpoints.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.endpoints.entities.user.UserMessage;

public   interface UserMessageRepository extends JpaRepository<UserMessage, Integer> {
	 
	@Query("SELECT message FROM UserMessage message WHERE message.sourceId.id=:id")
	List<UserMessage>findAllUserMessage(int id);
}
