package com.study.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class DifferentStreams {

	@Before
	public void setup() {
		System.out.println();
	}

	@Test
	public void streamUsingCollections() {
		Stream<String> strStream = Arrays.asList("a", "b", "c", "abc").stream();
		strStream.filter(s -> s.startsWith("a"))
				 .map(String::toUpperCase)
				 .findFirst()
				 .ifPresent(System.out::println);
	}
	
	@Test
	public void streamUsingObjectsDirectly() {
		Stream.of("a", 1, "b", 2, "c")
		.forEach(System.out::println);
	}
	
	
	@Test
	public void streamUsingPrimitives() {
		IntStream intStream = IntStream.range(1, 6);
		intStream.mapToObj(i -> i*i)
				 .forEach(System.out::println);
		
		IntStream.range(1, 5).average().ifPresent(System.out::println);
	}
	
	@Test
	public void mapObjectStreamToPrimitveStream() {
		Arrays.asList("1.0", "2.0", "3.0", "4.0")
			 .stream()
			 .mapToDouble(Double::parseDouble)
			 .max()
			 .ifPresent(System.out::println);
	}
	
	@Test
	public void mapPrimitiveStreamToObjectStream() {
		IntStream.range(1, 6)
				 .mapToObj(i -> "a" + i)
				 .forEach(System.out::println);
	}
	
}
