package com.study.basics;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class InbuilltFunctionalnterfaces {

	@Test
	public void functionWithChainedOperation() {
		Function<Integer, Person> ageToPerson = (i) -> new Person("He", i);
		Function<Integer, String> printPerson = ageToPerson.andThen(Person::print);

		printPerson.apply(26);
	}

	@Test
	public void predicateWithChainedOPeration() {
		Predicate<Person> isOld = p -> p.getAge() > 30;
		Person p = new Person("Vijay", 26);
		System.out.println(isOld.negate().test(p)); // true
	}

	@Test
	public void simpleSupplier() {
		Supplier<Person> personSupp = Person::new;
		personSupp.get().print();
	}

	@Test
	public void simpleConsumer() {
		Consumer<Person> greetingConsumer = p -> {
			System.out.println("Hi!! " + p.getName());
		};
		greetingConsumer.accept(PersonFixture.create());
	}

	@Test
	public void simplOptionalsUsage() {
		Optional<Person> personOpt = Optional.of(PersonFixture.create());
		System.out.println(personOpt.isPresent()); // true
		personOpt.ifPresent(p -> System.out.println("Getting option " + p));
		personOpt.get();
	}
}
