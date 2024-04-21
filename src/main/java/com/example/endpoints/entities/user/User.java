package com.example.endpoints.entities.user;

import java.time.LocalDateTime;
import java.util.List;

import com.example.endpoints.entities.group.Group;
import com.example.endpoints.entities.group.GroupMessage;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "user")
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	private String middleName;
	private String lastName;
	private String mobile;
	private String email;
	private String username;
	private String passwordHash;
	private LocalDateTime registeredAt;
	private LocalDateTime lastLogin;
	private String intro;
	private String profile;
	
	public User(String firstName, String middleName, String lastName, String mobile, String email, String username,
			String passwordHash, LocalDateTime registeredAt, LocalDateTime lastLogin, String intro, String profile
			 ) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.passwordHash = passwordHash;
		this.registeredAt = registeredAt;
		this.lastLogin = lastLogin;
		this.intro = intro;
		this.profile = profile;
		 
	 
	}
	
	

	@OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<UserPost> posts;
	
	@OneToMany(mappedBy ="targetId",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<UserMessage> messages;
	
	@OneToMany(mappedBy = "targetId")
	@ToString.Exclude
	private List<UserFriend>friends;
	
	@OneToMany(mappedBy="targetId")
	@ToString.Exclude
	private List<UserFollower>follwers;
	
 	@OneToMany(mappedBy="createdBy",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
 	@ToString.Exclude
 	private List<Group>groups;
 	
	@OneToMany(mappedBy="userId",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
	@ToString.Exclude
	private List<GroupMessage>groupsMessages;
 
	@OneToMany(mappedBy="userId",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
	@ToString.Exclude
	private List<GroupMessage>groupPosts;
 

}
