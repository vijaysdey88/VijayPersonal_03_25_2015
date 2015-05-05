package com.study.stream;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class ProcessingOrder {
	@Before
	public void setup() {
		System.out.println();
	}

	@Test
	public void statefulHorizontalProcessingWhileSorting() {
		System.out.println("Naive!!!");
		Stream.of(2, 1, 4, 3, 5)
			  .sorted((i1, i2) -> {
					System.out.println("Sorting");
					return i2.compareTo(i1);
				})
			  .filter(i -> {
					System.out.println("Filter " + i);
					return i >= 4;
				})
			  .forEach(System.out::println);;
	}
	
	@Test
	public void moreOptimizedWayFilterFirstAndThenSort() {
		System.out.println("Optimized!!!");
		Stream.of(2, 1, 4, 3, 5)
			  .filter(i -> {
				  System.out.println("Filter " + i);
				  return i >= 4;
			  })
			  .sorted((i1, i2) -> {
				  System.out.println("Sorting");
				  return i2.compareTo(i1);
			  })
			  .forEach(System.out::println);
	}

}
