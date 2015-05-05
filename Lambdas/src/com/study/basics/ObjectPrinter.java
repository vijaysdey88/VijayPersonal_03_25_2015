package com.study.basics;

import com.study.model.fixtures.PersonFixture;

public interface ObjectPrinter {

	void print(Object obj);
	
	//The target type of this expression must be a functional interface	ObjectPrinter.java	/Lambdas/src/com/study/basics	line 14	Java Problem
	//void printN(Object obj);
	
	public static void main(String[] args) {
		System.out.println("hi");
		
		ObjectPrinter op1 = obj -> System.out.println("Printing " + obj.toString());
		op1.print(PersonFixture.create());	
	}
}
