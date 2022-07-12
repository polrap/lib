package com.test.book.exception;

public class AlreadyExistingBookException extends RuntimeException{
	public AlreadyExistingBookException(String message) {
		super(message);
	}
}
