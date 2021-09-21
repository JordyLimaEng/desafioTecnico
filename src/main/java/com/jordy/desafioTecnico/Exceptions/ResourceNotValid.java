package com.jordy.desafioTecnico.Exceptions;

public class ResourceNotValid extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotValid(String errorsCombined) {		
		super(errorsCombined);
	}
}
