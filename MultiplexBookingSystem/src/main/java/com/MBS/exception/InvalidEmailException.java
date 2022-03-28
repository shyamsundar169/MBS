package com.MBS.exception;

public class InvalidEmailException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6747034632613054737L;

	public InvalidEmailException (String message) {
	   super(message);
	}
}
