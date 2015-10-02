package com.study.beans;

import java.util.List;

public class HelloWorldBean {
	
	private String message;
	private List<String> strList;
	
	public HelloWorldBean() {
		System.out.println("HelloWorldBean- inside constructor");
	}

	public void sayHello() {
		System.out.println("Hello!!! + " + message);
	}
	
	public void init() {
		System.out.println("HelloWorldBean- Initializing HW bean - " + message);
	}


	public void destroy() {
		System.out.println("HelloWorldBean- Destroying HW bean - " + message);
	}
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		System.out.println("Helloworld bean setting message");
		this.message = message;
	}

	public List<String> getStrList() {
		return strList;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + ", strList=" + strList
				+ "]";
	}

	
}	
