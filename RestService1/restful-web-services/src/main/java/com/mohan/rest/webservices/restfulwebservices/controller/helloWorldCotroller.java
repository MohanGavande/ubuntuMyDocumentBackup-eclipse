package com.mohan.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mohan.rest.webservices.restfulwebservices.beans.HelloWorldBean;

//Rest Service
@RestController
public class helloWorldCotroller {

	@Autowired
	private MessageSource messageSource;
	
	//GET
	//URI: hellow-world
	//Return: "Hello World"
	@GetMapping(path = "/hello-world")
	String getHellowWorld() {
		return "Hello World And What you are doing";
	}
	
	@GetMapping(path = "hello-world-string")
	HelloWorldBean getHelloWorldBean() {
		
		return new HelloWorldBean("Hello World");
	}
	
	//GEt
	//accept value from path variable
	//send the response using path variable.
	
	@GetMapping(path = "/hello-world/{name}")
	HelloWorldBean getHelloWorldBeanwithPathVar(@PathVariable String name) {
		
		return new HelloWorldBean(name);
	}
	/*
	 * @GetMapping(path = "/helloWorld-i18n") public String
	 * helloWorldInternationaliztion(@RequestHeader(name="Accept-Language", required
	 * = false) Locale locale) { return messageSource.getMessage("good.morning",
	 * null, locale); }
	 */
	
	@GetMapping(path = "/helloWorld-i18n")
	public String helloWorldInternationaliztion() {
		return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
	}


}
