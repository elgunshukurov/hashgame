package com.example.hashgame.exception;

public class UnsupportedPlayerTypeException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Unsupported player type!";

    public UnsupportedPlayerTypeException(String message) {
        super(message);
    }

    public UnsupportedPlayerTypeException(){
        super(DEFAULT_MESSAGE);
    }
}
