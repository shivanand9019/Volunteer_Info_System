package com.volunteer.info_system.dto;

import com.volunteer.info_system.utils.Role;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Role   role;
    
}
