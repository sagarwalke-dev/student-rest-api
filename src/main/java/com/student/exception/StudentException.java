package com.student.exception;

public class StudentException extends RuntimeException {

	public StudentException() {
		super();
	}

	public StudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StudentException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentException(String message) {
		super(message);
	}

	public StudentException(Throwable cause) {
		super(cause);
	}

}
