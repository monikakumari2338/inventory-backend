package com.inventory.exception;

import java.util.HashMap;
import java.util.Map;

public class ExcelValidationExceptionHandling extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Map<String, String> errorMessages;

	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}

	public ExcelValidationExceptionHandling(Map<String, String> errorMessages) {
		super("Exception");
		this.errorMessages = errorMessages;
	}

}
