package com.jsp.login.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialException extends RuntimeException {

	public InvalidCredentialException() {
		super("Invalid Credential");
	}

}
