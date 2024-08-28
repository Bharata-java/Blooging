package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.UserDto;

public interface UserService {

	public UserDto createUser(UserDto user);
	public UserDto updateUser(UserDto user,Integer userId);
	public UserDto getUserById(Integer userId);
	public List<UserDto> getAllUsers();
	
	void deleteUser(Integer userid);
	
	
}
