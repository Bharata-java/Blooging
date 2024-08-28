package com.example.demo.reposit;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Role;



  public interface RoleRepo extends JpaRepository<Role, Integer> {

    }
