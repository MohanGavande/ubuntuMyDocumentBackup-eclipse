package com.mohan.rest.webservices.restfulwebservices.beans;

public class HelloWorldBean {
	
	private String message;

	public HelloWorldBean(String string) {
		// TODO Auto-generated constructor stub
		this.message = toString(string);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString(String message) {
		return "My Message " + message;
	}
}
