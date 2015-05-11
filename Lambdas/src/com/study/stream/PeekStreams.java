package com.study.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import com.study.models.Person;

public class PeekStreams {
	
	
	@Test
	public void peekEachElementInBetweenOperations() {
		double avgAge  = IntStream
						.range(0, 6)
						.mapToObj(i -> new Person("a" + i, i*10))
						.peek(p -> {
							System.out.println("Peeking - " + p.getName());
						})
						.filter(p -> {
							System.out.println("Filtering - " + p.getName());
							return p.getName().startsWith("a1");
						})
						.peek(p -> {
							System.out.println("Peeking after filter - " + p.getName());
						})
						.collect(Collectors.averagingInt(Person::getAge));
		
		System.out.println("Average age - " + avgAge);
		
	}

}
