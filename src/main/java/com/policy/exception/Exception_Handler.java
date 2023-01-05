package com.policy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception_Handler {
	
	@ExceptionHandler(Policy_Not_Found_Exception.class)
	public ResponseEntity<String> getException(Policy_Not_Found_Exception exception) {
		return new ResponseEntity<String>("policy not found...", HttpStatus.NOT_FOUND);
	}

}
