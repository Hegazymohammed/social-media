package com.example.endpoints.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.endpoints.dto.group.ShowGroupResponseDto;
import com.example.endpoints.entities.group.Group;

public interface GroupRepository  extends JpaRepository<Group, Integer>{
 
}
