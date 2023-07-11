package com.cg.sakila.exception;

public class ActorNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActorNotFoundException() {
	}
	
	public ActorNotFoundException(String msg) {
		super(msg);
	}
}
