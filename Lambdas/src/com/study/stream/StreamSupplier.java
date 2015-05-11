package com.study.stream;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamSupplier {
	
	@Test
	public void supplierWithSameIntermediateOperations() {
		Supplier<Stream<String>> streamSupplier =
				() ->  IntStream
						.range(0, 10)
						.mapToObj(i -> "n" + i);
				
		System.out.println("T1 - " + streamSupplier.get().anyMatch(s -> s.equals("n1")));
		System.out.println("T2 - " + streamSupplier.get().noneMatch(s -> s.equals("n1")));
		streamSupplier.get().forEach(System.out::println);
					
	}

}
