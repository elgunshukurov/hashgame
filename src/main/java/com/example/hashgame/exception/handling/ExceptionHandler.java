package com.example.hashgame.exception.handling;

import com.example.hashgame.exception.UnsupportedPlayerTypeException;
import com.example.hashgame.exception.InvalidHashMoveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RequestError> handleIllegalArgumentException(IllegalArgumentException e) {
        LOGGER.error("Illegal argument passed: {}", e.getMessage());
        return new ResponseEntity<>(new RequestError(ErrorCode.ILLEGAL_ARGUMENT, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidHashMoveException.class)
    public ResponseEntity<RequestError> handleInvalidHashMoveException(InvalidHashMoveException e) {
        LOGGER.error("Invalid hash move: {}", e.getMessage());
        return new ResponseEntity<>(new RequestError(ErrorCode.INVALID_HASH_MOVE, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnsupportedPlayerTypeException.class)
    public ResponseEntity<RequestError> handleUnsupportedPlayerTypeException(UnsupportedPlayerTypeException e) {
        LOGGER.error("Unsupported player type: {}", e.getMessage());
        return new ResponseEntity<>(new RequestError(ErrorCode.UNSUPPORTED_PLAYER_TYPE, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}