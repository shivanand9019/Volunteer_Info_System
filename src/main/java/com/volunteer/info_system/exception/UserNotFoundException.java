package com.volunteer.info_system.exception;

public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException(Long id){
        super("User does not exists with id:"+id);
    }
    
    public UserNotFoundException(String email){
        super("User alrady exists with this email:"+email);
    }
}
