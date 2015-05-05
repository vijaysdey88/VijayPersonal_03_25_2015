package com.structures.bst;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BSTRangeTest extends BSTTestBasis {

	@Test
	public void rangeCountShouldReturnZeroForEmptyTree() {
		Assert.assertEquals(0, bst.rangeCount(15, 10));
	}

	@Test
	public void rangeCountShouldReturnNumberOfKeysBetweenStartAndEnd() {
		insertKeys(10, 12, 15, 18, 21);

		Assert.assertEquals(1, bst.rangeCount(11, 9));
		Assert.assertEquals(2, bst.rangeCount(13, 9));
		Assert.assertEquals(3, bst.rangeCount(16, 9));

		Assert.assertEquals(5, bst.rangeCount(22, 9));
		Assert.assertEquals(2, bst.rangeCount(22, 16));

		Assert.assertEquals("Should return zero for out of range", 0,
				bst.rangeCount(22, 25));
	}

	@Test
	public void rangeCountShouldIncludeLimits() {
		insertKeys(10, 12, 15, 18, 21);
		Assert.assertEquals(5, bst.rangeCount(21, 10));
	}

	@Test
	public void rangeSearchShouldReturnEmptyForOutOfRange() {
		insertKeys(10, 8, 12);
		Assert.assertTrue(bst.rangeSearch(13, 15).isEmpty());
	}

	@Test
	public void rangeSearchShouldReturnKeysInIntervalForThreeNodeTree() {
		insertKeys(10, 8, 12);

		List<Integer> keys = bst.rangeSearch(9, 11);
		assertKeysInRange(keys, 10);

		keys = bst.rangeSearch(8, 12);
		assertKeysInRange(keys, 8, 10, 12);

		keys = bst.rangeSearch(11, 12);
		assertKeysInRange(keys, 12);
	}

	@Test
	public void rangeSearchShouldReturnAllKeysInTheInterval() {
		insertKeys(10, 8, 12, 5, 14, 11, 15, 17, 1, 21, 25);

		List<Integer> keys = bst.rangeSearch(6, 18);
		assertKeysInRange(keys, 8, 10, 11, 12, 14, 15, 17);
	}


	private void assertKeysInRange(List<Integer> keys, Integer... expected) {
		Assert.assertEquals(expected.length, keys.size());
		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(expected[i], keys.get(i));
		}
	}
}
