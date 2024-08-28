package com.example.demo.reposit;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Comment;



 public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
	List<Comment> findByUserIdAndPostPostId(Integer userId, Integer postId);

   }
