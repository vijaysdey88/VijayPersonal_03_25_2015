package com.structures.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTRankSelectTest extends BSTTestBasis {
	private Integer[] seed = { 10, 8, 12, 4, 9, 2, 7, 11, 18, 15, 20 };

	@Before
	public void setup() {
		insertKeys(seed);
	}

	@Test
	public void sizeShouldKeepTrackOfNodesInsertedAtRoot() {
		newBST();
		int currentSize=0 ;
		Assert.assertEquals("Empty Tree", currentSize, bst.size());
		bst.put(10, 10);
		Assert.assertEquals("Root node inserted", ++currentSize, bst.size());
		bst.put(5, 5);
		Assert.assertEquals(++currentSize, bst.size());
		bst.put(15, 15);
		Assert.assertEquals(++currentSize, bst.size());
		
		bst.put(1, 5);
		Assert.assertEquals(++currentSize, bst.size());
		bst.put(17, 15);
		Assert.assertEquals(++currentSize, bst.size());
	}

	@Test
	public void rankForKeyLessThanEqualToRootIsEqualToSizeOfLeftSubtree() {
		newBST();
		bst.put(10, 10);
		Assert.assertEquals("No keys less than the root", 0, bst.rank(10));
		bst.put(5, 5);
		Assert.assertEquals("One key less than the root", 1, bst.rank(10));
		bst.put(15, 15);
		Assert.assertEquals("One key less than the root", 1, bst.rank(10));
		
		Assert.assertEquals("No key less than 5", 0, bst.rank(5));
		bst.put(1, 1);
		Assert.assertEquals("One key less than 5", 1, bst.rank(5));
		bst.put(0, 0);
		Assert.assertEquals("Two kesy less than 5", 2, bst.rank(5));
	}
	
	@Test
	public void rankForKeyGreaterThanRootIsSumAllSmallerKeysWhenFound() {
		newBST();
		insertKeys(10, 5, 1, 15);
		
		Assert.assertEquals( 3, bst.rank(15));
		insertKeys(13);
		Assert.assertEquals( 4, bst.rank(15));
		insertKeys(11);
		insertKeys(14);
		Assert.assertEquals( 6, bst.rank(15));
	
		insertKeys(18);
		Assert.assertEquals( 6, bst.rank(15));
	}
	
	@Test
	public void rankForKeyGreaterThanRootIsSumAllSmallerKeysWhenNotFound() {
		newBST();
		insertKeys(10, 5, 1, 15, 20, 12);
		
		Assert.assertEquals( 6, bst.rank(21));
		Assert.assertEquals( 4, bst.rank(15));
	}
	
	@Test
	public void sizeOfBottommostSubtreeShouldBeThree() {
		//Assert.assertEquals(3, bst.size(4));
		//Assert.assertEquals(3, bst.size(18));
	}

	@Test
	public void sizeShouldReturnNumberOfNodesWithKeyAsRoot() {
		int[] expectedSize = { 11, 5, 5, 3, 1, 1, 1, 1, 3, 1, 1 };
		for (int i = 0; i < expectedSize.length; i++) {
			//Assert.assertEquals(expectedSize[i], bst.size(seed[i]));

		}
	}
	
	@Test
	public void shouldReturnZeroWhenKeyNotFound() {
		newBST();
		//Assert.assertEquals(0, bst.size(10));
		bst.put(5, 5);
		//Assert.assertEquals(0, bst.size(10));
	}
}
