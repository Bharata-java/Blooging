package com.example.demo;


import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.config.AppConstants;
import com.example.demo.entity.Role;
import com.example.demo.reposit.RoleRepo;
@SpringBootApplication
public class BlogingProject1Application implements CommandLineRunner {

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
	SpringApplication.run(BlogingProject1Application.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

  @Override
	public void run(String... args) throws Exception {
		
		try {
			Role role1 = new Role();
			role1.setId(AppConstants.ADMIN_USER);
			role1.setName("ROLE_ADMIN");
			
			Role role2 = new Role();
			role2.setId(AppConstants.NORMAL_USER);
			role2.setName("ROLE_NORMAL");
			
			roleRepo.saveAll(Arrays.asList(role1, role2));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
   
}
