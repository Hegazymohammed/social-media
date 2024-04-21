package com.example.endpoints.exceptions;

public class IllegalUserException extends RuntimeException {

	public IllegalUserException(String message) {
		super(message);
	}
}
