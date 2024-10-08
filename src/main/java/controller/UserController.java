package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.UserDto;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {


		@Autowired
		private UserService userService;
		
		
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUsers() {
			return ResponseEntity.ok(userService.getAllUsers());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<UserDto> getUser(@PathVariable("id") Integer id) {
			return ResponseEntity.ok(userService.getUserById(id));
		}
		
		@PostMapping("/")
		public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
			UserDto createdUserDto = userService.createUser(userDto);
			return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") Integer id) {
			UserDto updatedUserDto =this. userService.updateUser(userDto, id);
			return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Integer id) {
			userService.deleteUser(id);
			return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true),  HttpStatus.OK);
		}
	
	
}
