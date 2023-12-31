package com.example.bookstore.resources.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.bookstore.service.exceptions.DataIntegrityViolationException;
import com.example.bookstore.service.exceptions.ObjectNotFoundException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardException> objectNotFoundException(ObjectNotFoundException e,
			ServletRequest request) {
		StandardException error = new StandardException(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardException> dataIntegrityViolationException(DataIntegrityViolationException e,
			ServletRequest request) {
		StandardException error = new StandardException(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardException> constraintViolationException(ConstraintViolationException e,
			ServletRequest request) {
		StandardException error = new StandardException(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException e, ServletRequest request){
		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Erro na validação dos campos");
		for (FieldError erro : e.getBindingResult().getFieldErrors() ) {
			error.addErrors(erro.getField(), erro.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
}
