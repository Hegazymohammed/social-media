package com.example.endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.endpoints.entities.group.GroupFollower;

public interface GroupFollowerRepository   extends JpaRepository<GroupFollower, Integer>{

}
