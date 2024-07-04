package com.pro1.UserManagementservice.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomException {
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach(error -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	  @ExceptionHandler(ResourceNotAvailableException.class)
		    @ResponseStatus(HttpStatus.NOT_FOUND)
		  public ResponseEntity<?> handleResourceNotAvailable(ResourceNotAvailableException ex){
			  return new ResponseEntity<>("ResourceNotAvailable",HttpStatus.NOT_FOUND);
		  }
	  @ExceptionHandler(NoSuchId.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
			  public ResponseEntity<?> handleNoSuchId(NoSuchId ns){
		  return new ResponseEntity<>("No Such Id",HttpStatus.NOT_FOUND);
	  }
}


