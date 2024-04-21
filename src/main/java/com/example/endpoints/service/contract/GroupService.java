package com.example.endpoints.service.contract;

import com.example.endpoints.dto.group.CreateGroupDto;
import com.example.endpoints.dto.group.ShowAllUserPostsResponseDto;
import com.example.endpoints.dto.group.ShowGroupResponseDto;

public interface GroupService {
	
  CreateGroupDto save(CreateGroupDto group);
  ShowGroupResponseDto findById(int groupId);
  ShowAllUserPostsResponseDto findAllPosts(int groupId);
}
