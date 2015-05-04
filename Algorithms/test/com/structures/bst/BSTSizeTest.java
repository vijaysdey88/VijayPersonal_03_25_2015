package com.structures.bst;


import org.junit.Assert;
import org.junit.Test;

public class BSTSizeTest extends BSTTestBasis {

	@Test
	public void shouldReturnZeroForEmptyTree() {
		Assert.assertEquals(0, bst.size(10));
	}

	@Test
	public void shouldReturnZeroFoKeyNotFound() {
		insertKeys(10, 5, 15, 20, 0);
		Assert.assertEquals(0, bst.size(12));
	}

	@Test
	public void shouldReturnOneForTreeHavingOnlyRootElement() {
		insertKeys(10);
		Assert.assertEquals(1, bst.size(10));
	}

	@Test
	public void shouldReturnSizeOfAllNodeForInTree() {
		insertKeys(10, 5, 15, 25, 13, 11);
		Assert.assertEquals(6, bst.size(10));
		Assert.assertEquals(1, bst.size(5));
		Assert.assertEquals(4, bst.size(15));
		Assert.assertEquals(1, bst.size(25));
		Assert.assertEquals(2, bst.size(13));
		Assert.assertEquals(1, bst.size(11));
	}

	@Test
	public void shouldGiveTotalSizeOfTheTree() {
		insertKeys(10, 5, 15, 25, 13, 11);
		Assert.assertEquals(6, bst.size());
	}

}
