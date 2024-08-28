package com.example.demo.payload;



import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostDto {

	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private UserDto user;
	private CategoryDto category;
	private List<CommentDto> comments = new ArrayList<>();

}
