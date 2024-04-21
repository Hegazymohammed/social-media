package com.example.endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.endpoints.entities.group.GroupPost;

public interface GroupPostRepository  extends JpaRepository<GroupPost, Integer>{

}
