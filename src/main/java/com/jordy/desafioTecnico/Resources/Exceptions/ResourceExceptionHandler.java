package com.jordy.desafioTecnico.Resources.Exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jordy.desafioTecnico.Exceptions.ResourceAlredyExists;
import com.jordy.desafioTecnico.Exceptions.ResourceCantBeUpdated;
import com.jordy.desafioTecnico.Exceptions.ResourceNotFoundException;
import com.jordy.desafioTecnico.Exceptions.ResourceNotValid;

@ControllerAdvice //intercepta as exceções para que faça o tratamento
public class ResourceExceptionHandler {
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> ResourceNotFoundException(ResourceNotFoundException e,
			HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ResourceAlredyExists.class)
	public ResponseEntity<StandardError> ResourceAlreadyExistsException(ResourceAlredyExists e,
			HttpServletRequest request) {
		String error = "Resource already exists";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ResourceCantBeUpdated.class)
	public ResponseEntity<StandardError> ResourceCantBeUpdatedException(ResourceCantBeUpdated e,
			HttpServletRequest request) {
		String error = "Resource cant be updated";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ResourceNotValid.class)
	public ResponseEntity<StandardError> ResourceNotValidException(ResourceNotValid e,
			HttpServletRequest request) {
		String error = "Resource not Valid";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
