package com.toystore.ecomm.ptms.daorepo.exception;

public class DatabaseCreationException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseCreationException(String errMsg) {
		super(errMsg);
	}

}
