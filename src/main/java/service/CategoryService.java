package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.payload.CategoryDto;

public interface CategoryService {
	
	// create 	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// delete
	void deleteCategory(Integer categoryId);
	
	// get
	CategoryDto getCategory(Integer categoryId);
	
	// get All
	List<CategoryDto> getAllCategories();
	

}
