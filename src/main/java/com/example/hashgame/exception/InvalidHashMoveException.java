package com.example.hashgame.exception;

public class InvalidHashMoveException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_MESSAGE = "Invalid hash move!";

	public InvalidHashMoveException(String message) {
		super(message);
	}

	public InvalidHashMoveException(){
		super(DEFAULT_MESSAGE);
	}
}
