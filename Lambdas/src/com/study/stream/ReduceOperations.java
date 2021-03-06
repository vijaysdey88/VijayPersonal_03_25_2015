package com.study.stream;

import java.util.List;
import java.util.function.BinaryOperator;

import org.junit.Before;
import org.junit.Test;

import com.study.model.fixtures.PersonFixture;
import com.study.models.Person;

public class ReduceOperations {
	
private List<Person> persons;
	
	@Before
	public void setup() {
		persons = PersonFixture.createList();
		System.out.println();
	}
	
	
	@Test
	public void reduceAllValuesToOneToFindMax() {
		BinaryOperator<Person> accumulator = (p1, p2) -> p1.getAge()>p2.getAge() ? p1 : p2;
		persons.stream()
				.reduce(accumulator)
				.ifPresent(System.out::println);
		
	}

	@Test
	public void reduceByAggregatingAllValuesInSingleObject() {
		BinaryOperator<Person> accumulator = (p1, p2) -> {
			p1.setName(p1.getName() + p2.getName());
			p1.setAge(p1.getAge() + p2.getAge());
			return p1;
		};

		Person reduced = persons.stream()
								.reduce(new Person("", 0), accumulator);
		System.out.println(reduced);
	}
	
	@Test
	public void combineMultipleParallelResultsUsingCombiner() {
		BinaryOperator<Person> accumulator = (p1, p2) -> {
			System.out.println("Accumulator : " + p1 + " > " +p2 );
			p1.setName(p1.getName() + p2.getName());
			p1.setAge(p1.getAge() + p2.getAge());
			return p1;
		};
		
		BinaryOperator<Person> combiner = (p1, p2) -> {
			System.out.println("Combiner : " + p1 + " > " +p2 );
			p1.setName(p1.getName() + p2.getName());
			p1.setAge(p1.getAge() + p2.getAge());
			return p1;
		};
		
		System.out.println("Sequential result...");
		System.out.println(persons
								.stream()
								.reduce(new Person("",0), accumulator, combiner)
				);
		
		System.out.println("Parallel result...");
		System.out.println(persons
								.parallelStream()
								.reduce(new Person("",0), accumulator, combiner)
				);
		
	}
}
