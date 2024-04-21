package com.example.endpoints.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.endpoints.entities.user.User;
import com.example.endpoints.entities.user.UserPost;

public   interface UserPostRepository extends JpaRepository<UserPost, Integer> {
	@Query("SELECT post FROM UserPost post WHERE post.userId.id=:userId")
	List<UserPost > findUserPostsByUserId(int userId);
	@Query("SELECT post FROM UserPost post WHERE post.userId.id=:userId and post.id=:postId")
	Optional<UserPost>findUserPostByPostIdAndUserId(int postId ,int userId);
}
