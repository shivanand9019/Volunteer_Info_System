package com.volunteer.info_system.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volunteer.info_system.dto.VolunteerRequest;
import com.volunteer.info_system.dto.VolunteerResponse;
import com.volunteer.info_system.repository.VolunteerRepository;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerRepository volunteerRepository;


    // public VolunteerResponse createVolunteer(VolunteerRequest volunteerRequest){
           

            

    // }
    // public List<VolunteerResponse> getAllVolunteers(){
    //         return new ArrayList<>();
    // }

    // public VolunteerResponse getVolunteerById(Long id){
    //     return volunteerRepository.findById(id);

    // }

    // public VolunteerResponse updateVolunteer(Long id,VolunteerRequest volunteerRequest){
    
    // }

    // public String deleteVolunteer(Long id){
    //     return "Success";
    
    // }
    
}
