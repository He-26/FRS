package com.frs.sakila.exception;

public class StaffNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public StaffNotFoundException() {
		
	}
	public StaffNotFoundException(String msg) {
		super(msg);
	}

}
