package com.example.endpoints.dto.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowGroupResponseDto {
 
    
    private String title;
    private String metaTitle;
    private String summary;
    private int status;
    private int createdBy;
}
