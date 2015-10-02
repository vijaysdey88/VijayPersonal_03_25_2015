package com.structures.bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTIterationTest extends BSTTestBasis {

	private List<Integer> accumulator = new ArrayList<Integer>();

	@Before
	public void setup() {
		newBST();
	}

	@Test
	public void shouldGetEmptyIterable() {
		Iterable<Integer> keys = bst.getKeys();

		Assert.assertNotNull(keys);
		accumulateKeys(keys);
		Assert.assertTrue(accumulator.isEmpty());
	}

	@Test
	public void shouldIterateInTheOrderLeftRootRightNode() {
		insertKeys(10, 5, 15);
		
		assertExpectedOrder(bst.getKeys(), 5, 10, 15);
	}

	@Test
	public void shouldIterateInAscendingOrder() {
		insertKeys(10, 5, 15, 3, 8, 13, 17, 1, 4, 18);

		assertExpectedOrder(bst.getKeys(), 1, 3, 4, 5, 8, 10, 13, 15, 17, 18);
	}

	private void assertExpectedOrder(Iterable<Integer> keys, Integer... expOrder) {
		accumulateKeys(keys);
		Assert.assertEquals(expOrder.length, accumulator.size());
		Iterator<Integer> it = accumulator.iterator();
		
		Stream<Integer> str = Stream.of(expOrder);
		str.forEach(expected -> {
			Assert.assertEquals(expected, it.next());
		});
	}


	private void accumulateKeys(Iterable<Integer> keys) {
		keys.forEach(k -> accumulator.add(k));
	}
}
