package com.example.endpoints.service;

public interface ICrudService<userRepository,mainRepository,classDto,createDtoRequest,updateDtoRequest> {
	createDtoRequest save(createDtoRequest dto);
	classDto find(int groupId,int post);
	
	

}
