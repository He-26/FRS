package com.cg.sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//for all exceptions
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException cnfe){
		return new ResponseEntity<>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<String> handleActorNotFoundException(ActorNotFoundException anfe){
		return new ResponseEntity<>(anfe.getMessage(),HttpStatus.NOT_FOUND);
	}
}
