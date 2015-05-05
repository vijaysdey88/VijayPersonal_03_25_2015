package com.study.basics;

public interface InterfaceWithDefault {

	String message();

	default String sayHi() {
		return "Hi!!!";
	}

}
