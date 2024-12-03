package com.jsp.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidCredentialException.class)
	ResponseEntity invalidCredentials(InvalidCredentialException e1) {
		return new ResponseEntity(e1.getMessage(),HttpStatus.NOT_FOUND);
	}
}
