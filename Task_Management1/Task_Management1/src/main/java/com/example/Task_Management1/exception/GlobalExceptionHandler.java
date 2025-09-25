package com.example.Task_Management1.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	  @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(EmailAlreadyExistsException.class)
	    public ResponseEntity<?> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex, WebRequest request) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    @ExceptionHandler(NameAlreadyExistsException.class)
	    public ResponseEntity<?> handleNameAlreadyExistsException(NameAlreadyExistsException ex, WebRequest request) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	    }
	    
	    @ExceptionHandler(EmailNotFoundException.class)
	    public ResponseEntity<String> handleEmailNotFoundException(EmailNotFoundException ex) {
	        // You can customize the response here
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	    
//	    @ExceptionHandler(EmailNotFoundException.class)
//	    public ResponseEntity<ErrorResponse> handleEmailNotFoundException(EmailNotFoundException ex, HttpServletRequest request) {
//	        ErrorResponse errorResponse = new ErrorResponse(
//	                HttpStatus.NOT_FOUND.value(),
//	                "Not Found",
//	                ex.getMessage(),
//	                request.getRequestURI()
//	        );
//	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//	    }
}
