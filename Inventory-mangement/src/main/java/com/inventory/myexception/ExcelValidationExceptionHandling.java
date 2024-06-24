package com.inventory.myexception;

import org.springframework.http.HttpStatus;

public class ExcelValidationExceptionHandling extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;

	public ExcelValidationExceptionHandling(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
