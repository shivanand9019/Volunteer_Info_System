package com.volunteer.info_system.dto;



import lombok.Data;

@Data
public class VolunteerRequest {
    private Long userId;
    private String phone;
    private String skills;
    private String availability;
    private String address;
    
}
