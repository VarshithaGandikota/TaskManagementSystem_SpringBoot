package com.example.Task_Management1.exception;

public class EmailNotFoundException extends RuntimeException{
	public EmailNotFoundException(String message) {
        super(message);
    }
}
