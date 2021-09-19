package com.jordy.desafioTecnico.Exceptions;

public class ResourceAlredyExists extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceAlredyExists(Object logic) {
		super("Resource Alredy Exists. logic " + logic);
	}
}
