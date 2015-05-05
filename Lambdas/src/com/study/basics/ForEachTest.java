package com.study.basics;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class ForEachTest {

	private List<Person> persons = PersonFixture.createList();

	@Before
	public void setup() {
		System.out.println();
	}

	@Test
	public void forEachUsingTyppicalLambdas() {
		System.out.println("Printing using typical lambdas...");
		persons.forEach(p -> System.out.println(p.toString()));
	}

	@Test
	public void forEachUsingMethodReference() {
		System.out.println("Printing using Method Reference lambdas...");
		persons.forEach(Person::print);
	}

	@Test
	public void forEachUsingCustomToStringFunction() {
		System.out.println("Printing using Method Reference + Function lambdas...");
		persons.forEach(p -> p.printCustom(r -> r.toString()));

		// No Allowed
		// persons.forEach(p -> p.printCustom(p -> p.toString()));
	}

}
