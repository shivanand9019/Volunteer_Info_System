package com.volunteer.info_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volunteer.info_system.entity.User;

public interface UserRepository  extends JpaRepository<User,Long>{
 public Boolean existsByEmail(String email);
    
} 
    

