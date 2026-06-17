package com.volunteer.info_system.exception;

public class VolunteerNotFoundException extends RuntimeException {
    public VolunteerNotFoundException(Long id){
        super("Volunteer does not exists with id:"+id);
    }
    
    
}
