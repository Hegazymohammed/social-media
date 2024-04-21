package com.example.endpoints.dto.userpost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class sharePostDto {
	private int id;
	private int userId;
	private int senderId;
	
}
