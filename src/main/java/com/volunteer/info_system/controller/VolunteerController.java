package com.volunteer.info_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volunteer.info_system.dto.VolunteerRequest;
import com.volunteer.info_system.dto.VolunteerResponse;
import com.volunteer.info_system.service.VolunteerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;
//    @PostMapping
//     public ResponseEntity<VolunteerResponse> createVolunteer(
//         @Valid @RequestBody VolunteerRequest volunteerRequest) {

//     return ResponseEntity.status(HttpStatus.CREATED)
//             .body(volunteerService.createVolunteer(volunteerRequest));
// }
    
}
