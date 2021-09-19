package com.jordy.desafioTecnico.Exceptions;

import org.json.JSONObject;

public class ResourceNotValid extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotValid(String errorsCombined) {		
		super(errorsCombined);
	}
}
