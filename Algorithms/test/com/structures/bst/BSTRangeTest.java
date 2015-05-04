package com.structures.bst;

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
		
		Assert.assertEquals("Should return zero for out of range", 0, bst.rangeCount(22, 25));
	}
	
	@Test
	public void rangeCountShouldIncludeLimits() {
		insertKeys(10, 12, 15, 18, 21);
		Assert.assertEquals(5, bst.rangeCount(21, 10));
	}
	
}
