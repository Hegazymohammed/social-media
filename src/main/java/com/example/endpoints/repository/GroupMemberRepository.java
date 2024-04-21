package com.example.endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.endpoints.entities.group.GroupMember;

public interface GroupMemberRepository   extends JpaRepository<GroupMember, Integer>{

}
