package com.jordy.desafioTecnico.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object logic) {
		super("Resouce not found. logic " + logic);
	}
}
