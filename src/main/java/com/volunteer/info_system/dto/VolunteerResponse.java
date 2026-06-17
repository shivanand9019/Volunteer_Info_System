package com.volunteer.info_system.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class VolunteerResponse {
    private Long id;
    private String phone;
    private String skills;
    private String availability;
    private String address;
    private LocalDate joinedDate;

    private String userName;
    private String userEmail;
    private Long userId;
    
}
