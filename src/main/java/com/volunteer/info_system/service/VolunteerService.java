package com.volunteer.info_system.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volunteer.info_system.dto.VolunteerRequest;
import com.volunteer.info_system.dto.VolunteerResponse;
import com.volunteer.info_system.entity.User;
import com.volunteer.info_system.entity.Volunteer;
import com.volunteer.info_system.exception.UserNotFoundException;
import com.volunteer.info_system.exception.VolunteerNotFoundException;
import com.volunteer.info_system.repository.UserRepository;
import com.volunteer.info_system.repository.VolunteerRepository;

@Service
public class VolunteerService {
 
    private final VolunteerRepository volunteerRepository;
    private final UserRepository userRepository;

    public VolunteerService(VolunteerRepository volunteerRepository,UserRepository userRepository){
        this.volunteerRepository = volunteerRepository;
        this.userRepository = userRepository;
    }


    public VolunteerResponse createVolunteer(VolunteerRequest volunteerRequest){

            
            User user = userRepository.findById(volunteerRequest.getUserId()).orElseThrow(()-> new UserNotFoundException(volunteerRequest.getUserId()));
            if(volunteerRepository.existsByUserId(volunteerRequest.getUserId())){
                throw new RuntimeException("Volunteer already exists  for this user");
            }

            Volunteer volunteer =  new Volunteer();
                volunteer.setPhone(volunteerRequest.getPhone());
                volunteer.setAddress(volunteerRequest.getAddress());
                volunteer.setAvailability(volunteerRequest.getAvailability());
                volunteer.setSkills(volunteerRequest.getSkills());
                volunteer.setJoinedDate(LocalDate.now());
                volunteer.setUser(user);

                Volunteer savedVol = volunteerRepository.save(volunteer);
                
                return convertToResponse(savedVol);
            

    }
    public List<VolunteerResponse> getAllVolunteers(){
        List<Volunteer> volunteers  = volunteerRepository.findAll();
         List<VolunteerResponse> responses = new ArrayList<>();

         for(Volunteer volunteer: volunteers){
            
            responses.add(convertToResponse(volunteer));
         }
            return  responses;
     }

    public VolunteerResponse getVolunteerById(Long id){
        Volunteer vol = volunteerRepository.findById(id).orElseThrow(()-> new VolunteerNotFoundException(id));
        return convertToResponse(vol);
    }
     



    public VolunteerResponse updateVolunteer(Long id,VolunteerRequest volunteerRequest){
        Volunteer vol = volunteerRepository.findById(id).orElseThrow(()-> new VolunteerNotFoundException(id));
        vol.setPhone(volunteerRequest.getPhone());
        vol.setSkills(volunteerRequest.getSkills());
        vol.setAvailability(volunteerRequest.getAvailability());
        vol.setAddress(volunteerRequest.getAddress());

        Volunteer updated = volunteerRepository.save(vol);

        return convertToResponse(updated);
        
     }

    public String deleteVolunteer(Long id){
        Volunteer volunteer = volunteerRepository.findById(id).orElseThrow(()-> new VolunteerNotFoundException(id));

        volunteerRepository.delete(volunteer);

        
        return "Volunteer Deleted Successfully";
    
    }
    
    private VolunteerResponse convertToResponse(Volunteer volunteer){
        VolunteerResponse response =  new VolunteerResponse();
            response.setId(volunteer.getId());
            response.setAddress(volunteer.getAddress());
            response.setAvailability(volunteer.getAvailability());
            response.setJoinedDate(volunteer.getJoinedDate());
            response.setPhone(volunteer.getPhone());
            response.setSkills(volunteer.getSkills());

            response.setUserId(volunteer.getUser().getId());
            response.setUserName(volunteer.getUser().getName());
            response.setUserEmail(volunteer.getUser().getEmail());

            return response;

    }
}
