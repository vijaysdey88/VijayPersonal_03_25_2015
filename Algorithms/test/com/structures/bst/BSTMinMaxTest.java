package com.structures.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTMinMaxTest extends BSTTestBasis {
	@Before
	public void setup() {
		Integer[] seed = { 10, 8, 12, 4, 9, 2, 7, 11, 18, 15, 20 };
		insertKeys(seed);
	}
	

	@Test
	public void minShouldReturnSmallestKey() {
		Assert.assertEquals(2, bst.min().intValue());
	}
	
	@Test
	public void maxShouldReturnSmallestKey() {
		Assert.assertEquals(20, bst.max().intValue());
	}
}
