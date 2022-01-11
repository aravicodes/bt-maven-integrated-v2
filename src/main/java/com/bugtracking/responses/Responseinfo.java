package com.bugtracking.responses;

import org.springframework.http.HttpStatus;

public class Responseinfo {
	private String uri;
	private int statusCode;
	private HttpStatus statusName;
	private String message;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Responseinfo(String uri, int statusCode, HttpStatus statusName, String message) {
		super();
		this.uri = uri;
		this.statusCode = statusCode;
		this.statusName = statusName;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public HttpStatus getStatusName() {
		return statusName;
	}

	public void setStatusName(HttpStatus statusName) {
		this.statusName = statusName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Responseinfo() {

	}

}
