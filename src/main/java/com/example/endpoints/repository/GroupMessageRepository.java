package com.example.endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.endpoints.entities.group.GroupMessage;

public interface GroupMessageRepository  extends JpaRepository<GroupMessage, Integer>{

}
