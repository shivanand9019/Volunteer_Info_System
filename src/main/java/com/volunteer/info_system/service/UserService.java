package com.volunteer.info_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.volunteer.info_system.dto.UserRequest;
import com.volunteer.info_system.entity.User;
import com.volunteer.info_system.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> createUser(UserRequest userRequest){
        
        
            if(!userRepository.existsByEmail(userRequest.getEmail())){
            User user =  new User();
            user.setEmail(userRequest.getEmail());
            user.setName(userRequest.getName());
            user.setPassword(userRequest.getPassword());
            user.setRole(userRequest.getRole());
            userRepository.save(user);
            } else{
            return ResponseEntity.status(404).body("User Already Exists with this email");

        }
            
        
        return ResponseEntity.status(201).body("User created Successfully");
        

        
    
    }
    
}
