package com.sport.custome_exception;

public class PlayerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PlayerException(String mesg) {
		super(mesg);
	}
}
