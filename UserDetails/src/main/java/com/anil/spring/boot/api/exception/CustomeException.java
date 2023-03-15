package com.anil.spring.boot.api.exception;

public class CustomeException {

	String errorMessage;

	public CustomeException() {
		super();
	}

	public CustomeException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
