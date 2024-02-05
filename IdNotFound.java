package com.jsp.courses.exception;

import lombok.Getter;

@Getter
public class IdNotFound extends RuntimeException {
	private String message;

	public IdNotFound(String message) {
		super();
		this.message = message;
	}



}
