package com.jordy.desafioTecnico.Exceptions;

public class ResourceCantBeUpdated extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceCantBeUpdated(Object logic) {
		super("Field logic = " + logic + " can't be updated");
	}
}
