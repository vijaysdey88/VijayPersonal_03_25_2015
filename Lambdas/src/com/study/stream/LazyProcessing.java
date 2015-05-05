package com.study.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class LazyProcessing {
	
	@Before
	public void setup() {
		System.out.println();
	}
	
	@Test
	public void noOperationsPerfomredIfTerminalOperationNotCalled() {
		IntStream.range(1, 10)
				 .filter(i -> {
					 			System.out.println("Filter : " + i);
					 			return i <=5;
					 		  }
						 );
	}
	
	@Test
	public void chainedOperationCalledVertically() {
		IntStream.range(1, 10)
				 .filter(i -> {
					 			System.out.println("Filter : " + i);
					 			return i <=5;
					 		  }
						 )
				 .forEach(i -> {
					 			System.out.println("ForEach : " + i);
				 				});
	}

	@Test
	public void chainedOperationCalledVertically2() {
		Stream.of("d2", "a2", "b1", "b3", "c")
		.map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});
	}

}
