package com.example.endpoints.entities.group;

import java.time.LocalDateTime;

import com.example.endpoints.entities.user.User;

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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="group_post")
public class GroupPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name="groupId")
	private Group groupId;
	@ManyToOne
	@JoinColumn(name="userId")
	private User userId;
	private String message;
	
}
