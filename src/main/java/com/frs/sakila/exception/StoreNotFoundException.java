package com.frs.sakila.exception;


public class StoreNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public StoreNotFoundException() {
		
	}
	public StoreNotFoundException(String msg) {
		super(msg);
	}

}
