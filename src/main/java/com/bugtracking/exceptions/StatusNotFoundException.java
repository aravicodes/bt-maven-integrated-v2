package com.bugtracking.exceptions;

public class StatusNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusNotFoundException(String msg) {
		super(msg);
	}

}
