package com.structures.bst;

import org.junit.Assert;
import org.junit.Test;

public class BSTRangeTest extends BSTTestBasis {

	@Test
	public void rangeCountShouldReturnZeroForEmptyTree() {
		Assert.assertEquals(0, bst.rangeCount(10, 15));
	}
	
	@Test
	public void shouldFindRangeForThreeNodeTree() {
		insertKeys(10, 12, 15);
		
		Assert.assertEquals(1, bst.rangeCount(9, 11));
	}
}
