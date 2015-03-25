package com.structures.bst;

import org.junit.Assert;
import org.junit.Test;

public class BSTGetPutTest {

	private BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();

	@Test
	public void putShouldInsertFirstElementAtTheRoot() {
		int key = 10;
		bst.put(key, TestUtil.computeValue(key));

		Assert.assertEquals(TestUtil.computeValue(key), bst.get(key));
	}

	@Test
	public void shouldStoreKeysHigherKeysRecursivelyToRightOfRoot() {
		Integer[] keys = { 5, 10, 15, 20, 25 };
		insertKeys(keys);

		assertRetrievingValues(keys);
	}

	@Test
	public void shouldStoreKeysSmallerKeysRecursivelyToLefttOfRoot() {
		Integer[] keys = { 25, 20, 15, 10, 5 };
		insertKeys(keys);

		assertRetrievingValues(keys);
	}

	@Test
	public void shouldReplaceValueWhenInsertingSameKey() {
		Integer[] keys = { 5, 10, 15, 20, 25 };
		insertKeys(keys);

		bst.put(15, 400);
		Assert.assertEquals(400, bst.get(15).intValue());
	}

	@Test
	public void getShouldReturnNullForEmptyTree() {
		Assert.assertNull(bst.get(123));
	}

	@Test
	public void getShouldReturnNullWhenKeyIsNotFound() {
		Integer[] keys = { 5, 10, 15, 20, 25 };
		insertKeys(keys);
		Assert.assertNull(bst.get(123));
	}


	private void insertKeys(Integer[] keys) {
		for (Integer key : keys) {
			bst.put(key, TestUtil.computeValue(key));
		}
	}

	private void assertRetrievingValues(Integer[] keys) {
		for (Integer key : keys) {
			Assert.assertEquals(TestUtil.computeValue(key), bst.get(key));
		}
	}

}
