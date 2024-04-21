package com.example.endpoints.dto.group;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Data
@NoArgsConstructor
public class CreateGroupDto {

    
    private   int createdBy;
    private   int updatedBy;
    private  String title;
	private   String slug;
	private int status;
	 
	 
	  
	
 	
	
}
