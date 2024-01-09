package com.example.test01;

import org.springframework.http.HttpStatus;

public final class ExceptionResponse extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String body;
	private final HttpStatus status;

	public ExceptionResponse(String body, HttpStatus status) {
		super(body);
		this.body = body;
		this.status = status;
	}

	public ExceptionResponse() {
		super();
		this.body = "";
		this.status = null;
	}

	public String getBody() {
		return body;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
