package com.MBS.exception;

public class InvalidPasswordException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 323660559957867005L;

	public InvalidPasswordException (String message) {
		super(message);
	}

}
