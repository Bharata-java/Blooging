package com.example.demo.USerImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.config.AppConstants;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.UserDto;
import com.example.demo.reposit.RoleRepo;
import com.example.demo.reposit.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
     @Autowired
	private UserRepository reposit;
     
  @Autowired
    ModelMapper modelMapper ;
  @Autowired
	private RoleRepo roleRepo;
  
    @Override
	public UserDto createUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		user.getRoles().add(role);
		
		User savedUser = reposit.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		//User user=this.dtoToUser(userDto);
		User  user=this.reposit.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User", "id",userId));
		user.setId(userDto.getId());
	 user.setAbout(userDto.getAbout());
	 user.setEmail(userDto.getEmail());
	 user.setName(userDto.getName());
	 user.setPassword(userDto.getPassword());
		User updateUser=this.reposit.save(user);
		
		UserDto userDto1=this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
	  User user=this.reposit.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User", "id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> user=(List<User>) this.reposit.findAll();
		List<UserDto> userDtos=user.stream().
                               
				          map((users)->this.userToDto(users)).
                              
                               collect(Collectors.toList());
		
		return userDtos;
	}
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	public void deleteUser(Integer userid) {
	 User user=this.reposit.findById(userid).
	
			 orElseThrow(()-> new ResourceNotFoundException("User", "id",userid));
	
	 this.reposit.delete(user);
	 
	 
	}
	
	

	private User dtoToUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto, User.class);
		
	// below is the manual mapping 
		/*User user=new User();
		user.setId(userDto.getId());
	   user.setAbout(userDto.getAbout());
	   user.setEmail(userDto.getEmail());
	  user.setName(userDto.getName());
	 user.setPassword(userDto.getPassword());*/
		
	 return user;

	   }
	private UserDto userToDto(User user) {
		UserDto dto=this.modelMapper.map(user, UserDto.class);
	 /* dto.setId(user.getId());
	  dto.setName(user.getName());
	  dto.setEmail(user.getEmail());
	  dto.setPassword(user.getPassword());
	  dto.setAbout(user.getAbout());*/
	     
		return dto;

	   }
	
	
	

}
