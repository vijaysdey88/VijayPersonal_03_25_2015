package com.study.practice;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class IntStreamPractice {

	@Test
	public void iterateOverCounter() {
		System.out.println("Iterate function...");
		IntStream.iterate(0, i -> i + 1)
		          .limit(10)
		          .mapToObj(i -> "i=" + i)
		          .forEach(System.out::println);
	}

	@Test
	public void rangeOverReplacingTraditionalForLoop() {
		System.out.println("Range function...");
		IntStream.range(0, 6)
				.forEach(i -> System.out.println("i - " + i));
	}
	
	@Test
	public void createARandomArray() {
		Random random = new Random();
		
		System.out.println("First random Stream");
		IntStream.generate(random::nextInt)
				 .limit(10)
				 .boxed()
				 //.toArray(Integer[]::new);
				 .forEach(System.out::println);

		System.out.println("Second random Stream");
		random.ints(15)
			  .limit(7)
		 	  .forEach(System.out::println);
	}
	
	@Test
	public void convertObjectStreamToPrimitive() {
		System.out.println(
			"Sum of stream - " +
			Stream
				.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.sum()
		);
	}
	
	@Test
	public void convertPrimitiveStreamToObject() {
		IntStream.range(0, 6)
			.map(n -> n*n)
			.mapToObj(n -> "n" + n)
			.forEach(System.out::println);
	}

}
