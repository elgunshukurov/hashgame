package com.example.hashgame.exception.handling;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class RequestError implements Serializable {
	private int errorId;
    private LocalDateTime timestamp;
    private String errorCode;
    private String errorMessage;

    public RequestError() {}

    public RequestError(ErrorCode errorCode, String errorMessage, LocalDateTime timestamp) {
        this.errorId = errorCode.getId();
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public RequestError(ErrorCode errorCode, String errorMessage) {
        this(errorCode, errorMessage, LocalDateTime.now());
    }
}