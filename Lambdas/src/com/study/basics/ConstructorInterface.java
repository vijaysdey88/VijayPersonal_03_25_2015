package com.study.basics;

import org.junit.Test;

import com.study.models.Person;

public class ConstructorInterface {

	@Test
	public void useConstructorReferenceToCreatePersonFactoryLambda() {
		PersonFactory pf = Person::new;
		System.out.println(pf.create("abc", 12));
	}

}
