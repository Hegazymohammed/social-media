package com.example.endpoints.entities.user;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
 
@NoArgsConstructor
@Entity
@Table(name = "user_post")
public class UserPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private int id;

	@ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name = "userId")
	@ToString.Exclude
	private User userId;

	@ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name = "senderId")
	@ToString.Exclude
	 private User senderId;

	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime UpdatedAt;
	
	public UserPost( String message, LocalDateTime createdAt, LocalDateTime updatedAt) {
		 
		this.senderId = senderId;
		this.message = message;
		this.createdAt = createdAt;
		UpdatedAt = updatedAt;
	}

	public UserPost(User userId, User senderId, String message, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.userId = userId;
		this.senderId = senderId;
		this.message = message;
		this.createdAt = createdAt;
		UpdatedAt = updatedAt;
	}
	
	

}
