package com.study.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class BasicStreams {
	private List<Person> persons = PersonFixture.createList();;

	@Before
	public void setup() {
		System.out.println();
	}

	@Test
	public void chainFilteringAndPrinting() {
		System.out.println("Simple filtering...");
		persons.stream().filter(p -> p.getName().startsWith("Vijay")).forEach(Person::print);
	}

	@Test
	public void moreChaining() {
		System.out.println("More filtering...");
		Stream<Person> personStream = persons.stream();
		personStream.filter(p -> p.getName().startsWith("Vijay")).filter(p -> p.getAge() > 20).forEach(Person::print);

		// IllegalState stream has already been operated upon or closed
		// personStream.filter(p -> false);
	}

	@Test(expected = IllegalStateException.class)
	public void streamCanBeConsumedOnlyOnce() {
		Stream<Person> personStream = persons.stream();
		personStream.filter(p -> p.getName().startsWith("Vijay")).filter(p -> p.getAge() > 20).forEach(Person::print);

		// IllegalState stream has already been operated upon or closed
		personStream.filter(p -> false);
	}

	@Test
	public void collectOutputOfOperationPerformedOnStream() {
		List<Person> onlyVijays = persons.stream()
										 .filter(p -> p.getName().startsWith("Vijay"))
										 .filter(p -> p.getAge() > 20)
				.collect(Collectors.toList());
		System.out.println("Filtered list...");
		onlyVijays.forEach(p -> p.printCustom(r -> "Printing " + r.getName() + " age :" + r.getName()));
	}

	@Test
	public void calculateSumOfAllAges() {
		IntStream intStream = persons.stream().mapToInt(p -> p.getAge());
		System.out.println("Sum of all ages - " + intStream.sum());
	}
	
	@Test
	public void sumOfAllBasedOnFilteredSet() {
		DoubleStream doubleStream = persons.parallelStream()
									.filter(p -> p.getName().startsWith("Vijay"))
									.mapToDouble(p -> p.getAge());
		System.out.println("Average of all Vijay ages using double- " + doubleStream.average().getAsDouble());

		doubleStream = persons.parallelStream()
							  .mapToDouble(p -> p.getAge())
							  .filter(age -> age > 25);
		System.out.println("Average age of adults - " + doubleStream.average().getAsDouble());
	}


}
