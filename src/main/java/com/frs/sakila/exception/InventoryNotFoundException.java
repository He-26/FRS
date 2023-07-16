package com.frs.sakila.exception;

public class InventoryNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InventoryNotFoundException() {

    }
    public InventoryNotFoundException(String msg) {
        super(msg);
    }


}