package com.anhanguera.projeto.domain.exception;

public class EntidadeNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public EntidadeNotFoundException(String message) {
		super(message);
	}

}
