package com.volunteer.info_system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

   
    private final VolunteerService volunteerService;
    public VolunteerController(VolunteerService volunteerService){
        this.volunteerService = volunteerService;
    }
   @PostMapping
    public ResponseEntity<VolunteerResponse> createVolunteer(
        @Valid @RequestBody VolunteerRequest volunteerRequest) {

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(volunteerService.createVolunteer(volunteerRequest));
        }
    
    @GetMapping
    public ResponseEntity<List<VolunteerResponse>> getAllVolunteers(){
        
        return ResponseEntity.ok(volunteerService.getAllVolunteers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteerResponse> getVolunteerById(@PathVariable Long id){
        return ResponseEntity.ok(volunteerService.getVolunteerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VolunteerResponse> updateVolunteer(@PathVariable Long id,@RequestBody VolunteerRequest volunteerRequest){
        return ResponseEntity.ok(volunteerService.updateVolunteer(id, volunteerRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVolunteer(@PathVariable Long id){
        return ResponseEntity.ok(volunteerService.deleteVolunteer(id));
    }
}
