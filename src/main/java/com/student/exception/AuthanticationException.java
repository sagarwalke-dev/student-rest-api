package com.student.exception;

public class AuthanticationException extends RuntimeException {

	public AuthanticationException() {
		super();
	}

	public AuthanticationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthanticationException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthanticationException(String message) {
		super(message);
	}

	public AuthanticationException(Throwable cause) {
		super(cause);
	}

}
