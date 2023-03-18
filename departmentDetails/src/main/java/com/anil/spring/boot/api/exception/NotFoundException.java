package com.anil.spring.boot.api.exception;

public class NotFoundException extends RuntimeException {

	String errorMessage;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public NotFoundException() {
		super();
	}

}
