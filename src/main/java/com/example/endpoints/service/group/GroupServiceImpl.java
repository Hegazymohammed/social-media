package com.example.endpoints.service.group;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.endpoints.dto.group.CreateGroupDto;
import com.example.endpoints.dto.group.ShowAllUserPostsResponseDto;
import com.example.endpoints.dto.group.ShowGroupResponseDto;
import com.example.endpoints.entities.group.Group;
import com.example.endpoints.entities.user.User;
import com.example.endpoints.exceptions.GroupNotFoundException;
import com.example.endpoints.exceptions.UserNotFoundException;
import com.example.endpoints.repository.GroupRepository;
import com.example.endpoints.repository.UserRepository;
import com.example.endpoints.service.contract.GroupService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

	private final UserRepository userRepository;
	private final GroupRepository groupRepository;
	private final ModelMapper mapper;
	@Autowired
	public GroupServiceImpl(UserRepository userRepository, GroupRepository groupRepository,ModelMapper mapper) {
		this.mapper=mapper;
		this.userRepository = userRepository;
		this.groupRepository = groupRepository;
	}


	@Override
	public CreateGroupDto  save(CreateGroupDto dto) {
		 Optional<User> user=userRepository.findById(dto.getCreatedBy());
		 if(!user.isPresent())
			 throw new UserNotFoundException("User not found");
		LocalDateTime creation=LocalDateTime.now();
		 
		Group group=mapper.map(dto, Group.class);
		 
	 
	    group.setCreatedBy(user.get());
	    group.setUpdatedBy(user.get());
		group.setCreatedAt(creation);
		group.setUpdatedAt(creation);
		log.info(group.toString());
		Group reterivedE=groupRepository.save(group);
	  /*
	TypeMap<Group, CreateGroupDto> typeMap = mapper.createTypeMap(Group.class, CreateGroupDto.class);
typeMap.addMappings(
    mapper -> mapper.map(Group::getCreatedBy, CreateGroupDto::setCreatedBy)
);

	   */
		TypeMap<Group, CreateGroupDto>typemap=mapper.createTypeMap(Group.class, CreateGroupDto.class);
		typemap.addMappings(
			      mapper -> mapper.map(g->g.getCreatedBy().getId(), CreateGroupDto::setCreatedBy)
			      );
		typemap.addMappings(mapper->mapper.map(g->g.getUpdatedBy().getId(), CreateGroupDto::setUpdatedBy));
		return mapper.map(reterivedE, CreateGroupDto.class) ;
		
	}
	@Override
	public ShowGroupResponseDto findById(int groupId) {
		Optional<Group>group=groupRepository.findById(groupId);
		if(!group.isPresent())
			throw new GroupNotFoundException("This group doesn't exist");
		
		TypeMap<Group,ShowGroupResponseDto>typeMap=mapper.createTypeMap(Group.class, ShowGroupResponseDto.class);
		typeMap.addMappings(
					mapper->mapper.map(grou->grou.getCreatedBy().getId(), ShowGroupResponseDto::setCreatedBy)
				);
		 return mapper.map(group, ShowGroupResponseDto.class);
		
	}


	@Override
	public ShowAllUserPostsResponseDto findAllPosts(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 

}
