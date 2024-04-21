package com.example.endpoints.entities.user;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@Entity
@Table(name="user_friend")
public class UserFriend {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="sourceId")
	@JsonIgnore
	@ToString.Exclude
	private User sourceId;
	@ManyToOne
	@JoinColumn(name="targetId")
	@ToString.Exclude
	private User targetId;
	
	private int status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String notes;
	
	

}
