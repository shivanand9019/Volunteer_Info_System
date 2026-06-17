package com.volunteer.info_system.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.volunteer.info_system.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(VolunteerNotFoundException.class)
public ResponseEntity<ErrorResponse> volunteerNotFound(
        VolunteerNotFoundException ex) {

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setMessage(ex.getMessage());
    errorResponse.setStatus(404);

    return ResponseEntity.status(404)
            .body(errorResponse);
}
@ExceptionHandler(UserNotFoundException.class)
public ResponseEntity<ErrorResponse> userNotFound(
        UserNotFoundException ex) {

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setMessage(ex.getMessage());
    errorResponse.setStatus(404);

    return ResponseEntity.status(404)
            .body(errorResponse);
}
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorResponse> UnKnownExeption(
        Exception ex) {

    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setMessage("Something Went Wrong");
    errorResponse.setStatus(500);

    return ResponseEntity.status(500)
            .body(errorResponse);
}

    
}
