package com.volunteer.info_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volunteer.info_system.dto.UserRequest;

import com.volunteer.info_system.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }
    
}
