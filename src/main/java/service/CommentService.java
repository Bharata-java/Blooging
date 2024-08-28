package com.example.demo.service;



import java.util.List;

import com.example.demo.payload.CommentDto;



public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
	void deleteComment(Integer commentId);
	List<CommentDto> getCommentOfUserWithPostId(Integer postId, Integer userId); 

}
