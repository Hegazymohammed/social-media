package com.example.endpoints.entities.user;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
 
@Entity
@Table(name="user_message")
public class UserMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
    @JoinColumn(name="sourceId"  )
	private User   sourceId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="targetId" )
	@ToString.Exclude
	private User targetId;
	
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime UpdatedAt ;
}
