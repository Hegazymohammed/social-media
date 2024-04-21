package com.example.endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.endpoints.entities.group.GroupMeta;

public interface GroupMetaRepository  extends JpaRepository<GroupMeta, Integer>{

}
