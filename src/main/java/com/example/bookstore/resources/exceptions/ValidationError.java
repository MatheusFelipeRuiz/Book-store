package com.example.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardException {

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer status, String message) {
		super(timestamp, status, message);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message ) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
