package com.structures.pq;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListBasedOrderedMinPQTest {
	private LinkedListBasedOrderedMinPQ<Integer> pq = new LinkedListBasedOrderedMinPQ<Integer>();

	@Test
	public void shouldRemoveTheMaxOutOfItemsInsertedInRandomOrder() {
		Supplier<Stream<Integer>> sequenceStreamSupplier = () -> {
			return IntStream.range(0, 10)
					  .boxed();
		};
		
		List<Integer> input = toList(sequenceStreamSupplier);
		Collections.shuffle(input);
		input.forEach(pq::insert);
		
		input = toList(sequenceStreamSupplier);
		input.stream()
			 .forEach((i) -> Assert.assertEquals(i, pq.remove()));
	}
	
	private List<Integer> toList(Supplier<Stream<Integer>> sequenceStreamSupplier) {
		return sequenceStreamSupplier.get().collect(Collectors.toList());
	}
}
