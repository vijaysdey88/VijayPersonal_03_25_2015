package com.structures.bst;

import static com.utility.TestUtil.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTFloorCielingTest extends BSTTestBasis {

	@Before
	public void setup() {
		Integer[] seed = { 10, 8, 12, 4, 9, 2, 7, 11, 18, 15, 20 };
		insertKeys(seed);
	}

	@Test
	public void floorShouldLookForExactMatchAtRoot() {
		Assert.assertEquals(computeValue(10), bst.floor(10));
	}

	@Test
	public void floorShouldGetMatchWhenKeyLesserThanRoot() {
		Assert.assertEquals(computeValue(8), bst.floor(8));
		Assert.assertEquals(computeValue(4), bst.floor(4));
		Assert.assertEquals(computeValue(2), bst.floor(2));
	}

	@Test
	public void floorShouldGetMatchWhenKeyGreaterThanRoot() {
		Assert.assertEquals(computeValue(12), bst.floor(12));
		Assert.assertEquals(computeValue(18), bst.floor(18));
		Assert.assertEquals(computeValue(20), bst.floor(20));
	}

	@Test
	public void floorShouldGetMatchByTraversingZigZag() {
		Assert.assertEquals(computeValue(9), bst.floor(9));
		Assert.assertEquals(computeValue(11), bst.floor(11));
	}

	@Test
	public void floorShouldReturnNullWhenSearchKeyLessThanSmallestKey() {
		Assert.assertNull(bst.floor(1));
	}

	@Test
	public void floorShouldReturnLargestNodeLessThanTheSearchKey() {
		Assert.assertEquals(computeValue(4), bst.floor(6));
		Assert.assertEquals(computeValue(18), bst.floor(19));
		Assert.assertEquals(computeValue(15), bst.floor(17));
		Assert.assertEquals(computeValue(20), bst.floor(21));
	}
	
}
