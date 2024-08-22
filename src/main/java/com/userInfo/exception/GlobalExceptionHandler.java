package com.userInfo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleException(Exception e) {
	        logger.error("Exception: ", e);
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
