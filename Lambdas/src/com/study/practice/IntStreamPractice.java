package com.study.practice;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class IntStreamPractice {

	@Test
	public void iterateOverCounter() {
		IntStream.iterate(0, i -> i + 1)
		          .limit(10)
		          .mapToObj(i -> "i=" + i)
		          .forEach(System.out::println);
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

}
