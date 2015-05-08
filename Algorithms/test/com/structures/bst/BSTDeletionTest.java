package com.structures.bst;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class BSTDeletionTest extends BSTTestBasis {

	@Test
	public void deleteMinShouldDeleteTheRoot() {
		int key = 10;
		insertKeys(key);
		bst.deleteMin();
		
		notExists(key);
		Assert.assertEquals(0, bst.size());
	}

	@Test
	public void deleteMinShouldDeleteTheSmallestElement() {
		insertKeys(10, 5, 15, 25, 13, 11);
		bst.deleteMin();

		Assert.assertNull(bst.get(5));
		assertRetrievingValues(10, 15, 25, 13, 11);

		bst.deleteMin();
		Assert.assertNull(bst.get(10));
		assertRetrievingValues(15, 25, 13, 11);
	}

	@Test
	public void deleteMinShouldDoNothingWhenTreeIsEmpty() {
		bst.deleteMin();
		Assert.assertEquals(0, bst.size());
	}

	@Test
	public void deleteMinShouldRectifySizes() {
		insertKeys(10, 5, 15, 25, 13, 11);

		bst.deleteMin(); 
		
		assertSizesAtEveryNode(Lists.newArrayList(10, 15, 25, 13, 11), Lists.newArrayList(5, 4, 1, 2, 1));
	}

	@Test
	public void deleteShouldRemoveTheLeafNode() {
		List<Integer> keys = Lists.newArrayList(10, 5, 15, 3, 8, 12, 17, 20, 1);
		insertKeys(keys.toArray(new Integer[] {}));

		int leaf = 1;
		bst.delete(leaf);

		notExists(leaf);
		assertRetrievingValues(Lists.newArrayList(10, 5, 15, 3, 8, 12, 17, 20));
	}

	@Test
	public void deleteShouldDoNothingForEmptyTree() {
		bst.delete(10);
		Assert.assertEquals(0, bst.size());
	}

	// Key 3 has a single child 1
	@Test
	public void deleteShouldReplaceTheKeyToDeletedWhenIthasSingleChildInLeft() {
		List<Integer> keys = Lists.newArrayList(10, 5, 15, 3, 8, 12, 17, 20, 1);
		insertKeys(keys.toArray(new Integer[] {}));

		int keyWithSingleChild = 3;
		bst.delete(keyWithSingleChild);

		notExists(keyWithSingleChild);
		assertRetrievingValues(Lists.newArrayList(10, 5, 15, 8, 12, 17, 20, 1));
	}

	// Key 3 has a single child 4
	@Test
	public void deleteShouldReplaceTheKeyToDeletedWithSingleChildInRight() {
		List<Integer> keys = Lists.newArrayList(10, 5, 15, 3, 8, 12, 17, 20, 4);
		insertKeys(keys.toArray(new Integer[] {}));

		int keyWithSingleChild = 3;
		bst.delete(keyWithSingleChild);

		notExists(keyWithSingleChild);
		assertRetrievingValues(Lists.newArrayList(10, 5, 15, 8, 12, 17, 20, 4));
	}

	@Test
	public void deleteShouldRemoveTheKeyAndReplaceWithSmallestKeyInRightTreeWhenItHasTwoChildren() {
		List<Integer> keys = Lists.newArrayList(10, 5, 15, 3, 8, 12, 17, 20, 1, 6, 9);
		insertKeys(keys.toArray(new Integer[] {}));

		int keyWith2Child = 5;
		bst.delete(keyWith2Child);

		notExists(keyWith2Child);
		assertRetrievingValues(Lists.newArrayList(10, 15, 3, 8, 12, 17, 20, 1, 6, 9));
	}

	@Test
	public void deleteShouldRectifySizesAtEachNode() {
		List<Integer> keys = Lists.newArrayList(10, 5, 15, 3, 8, 12, 17, 20, 1, 6, 9);
		insertKeys(keys.toArray(new Integer[] {}));

		bst.delete(5);

		Assert.assertEquals(10, bst.size());
		assertSizesAtEveryNode(Lists.newArrayList(10, 15, 3, 8, 12, 17, 20, 1, 6, 9), Lists.newArrayList(10, 4, 2, 2, 1, 2, 1, 1, 5, 1));
	}

	private void assertSizesAtEveryNode(List<Integer> keys, List<Integer> expectedSizes) {
		IntStream.iterate(0, i -> i++)
				 .limit(keys.size())
				 .forEach(i -> {
						Assert.assertEquals("Incorrect size for key " + keys.get(i), expectedSizes.get(i).intValue(), bst.size(keys.get(i)));
				  });
	}
	
	private void notExists(int key) {
		Assert.assertNull(bst.get(key));
	}

}
