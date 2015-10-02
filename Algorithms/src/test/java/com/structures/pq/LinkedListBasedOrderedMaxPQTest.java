package com.structures.pq;


import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListBasedOrderedMaxPQTest {
	
	private LinkedListBasedOrderedMaxPQ<Integer> pq = new LinkedListBasedOrderedMaxPQ<Integer>();
	
	@Test
	public void shouldInsertAndRetrieveSingleItem() {
		pq.insert(20);
		Assert.assertEquals(20, pq.remove().intValue());
	}
	
	@Test
	public void shouldReturnNullWhenEmpty() {
		Assert.assertNull(pq.remove());
	}
	
	@Test
	public void shouldRemoveTheMaxOutOfItemsInsertedInDescOrder() {
		pq.insert(20);
		pq.insert(19);
		pq.insert(18);
		Assert.assertEquals(20, pq.remove().intValue());
		Assert.assertEquals(19, pq.remove().intValue());
		Assert.assertEquals(18, pq.remove().intValue());
	}
	
	@Test
	public void shouldRemoveTheMaxOutOfItemsInsertedInAscOrder() {
		pq.insert(18);
		pq.insert(19);
		pq.insert(20);
		
		Assert.assertEquals(20, pq.remove().intValue());
		Assert.assertEquals(19, pq.remove().intValue());
		Assert.assertEquals(18, pq.remove().intValue());
	}
	
	@Test
	public void shouldRemoveTheGetMaxDuplicate() {
		pq.insert(18);
		pq.insert(19);
		pq.insert(20);
		pq.insert(20);
		
		Assert.assertEquals(20, pq.remove().intValue());
		Assert.assertEquals(20, pq.remove().intValue());
		Assert.assertEquals(19, pq.remove().intValue());
		Assert.assertEquals(18, pq.remove().intValue());
	}
	
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
		Collections.reverse(input);
		input.stream()
			 .forEach((i) -> Assert.assertEquals(i, pq.remove()));
	}
	
	@Test
	public void shouldTrackSizeOfTheQueue() {
		Assert.assertEquals(0, pq.size());
		pq.insert(18);
		pq.insert(17);
		pq.insert(20);
		Assert.assertEquals(3, pq.size());
		
		pq.remove();
		pq.remove();
		pq.remove();
		Assert.assertEquals(0, pq.size());
	}

	private List<Integer> toList(Supplier<Stream<Integer>> sequenceStreamSupplier) {
		return sequenceStreamSupplier.get().collect(Collectors.toList());
	}
}
