package com.frs.sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.frs.sakila.entity.Custom_Excpetion;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException cnfe){
		//return new ResponseEntity<>(cnfe.getMessage(),HttpStatus.NOT_FOUND);
		Custom_Excpetion ex=new Custom_Excpetion(cnfe.getMessage());
		return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<?> handleActorNotFoundException(ActorNotFoundException anfe){
		Custom_Excpetion ex=new Custom_Excpetion(anfe.getMessage());
		return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InventoryNotFoundException.class)
    public ResponseEntity<?> handleInventoryNotFoundException(InventoryNotFoundException infe){
        Custom_Excpetion ex=new Custom_Excpetion(infe.getMessage());
        return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<?> handleStoreNotFoundException(StoreNotFoundException snfe){
        Custom_Excpetion ex=new Custom_Excpetion(snfe.getMessage());
        return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(StaffNotFoundException.class)
    public ResponseEntity<?> handleStaffNotFoundException(StaffNotFoundException snfe){
        Custom_Excpetion ex=new Custom_Excpetion(snfe.getMessage());
        return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
    }
}
