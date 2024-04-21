package com.example.endpoints.dto.group;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupPostDto {
	private int userId;
	private String message;
	private LocalDateTime creation;
}
