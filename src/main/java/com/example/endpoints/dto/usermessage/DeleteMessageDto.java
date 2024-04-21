package com.example.endpoints.dto.usermessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DeleteMessageDto {

	private int id;
	private int senderId;
	private int reciverId;
}
