package com.structures.bst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Assert;

import com.utility.TestUtil;

public abstract class BSTTestBasis {
	protected BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();

	protected void newBST() {
		bst = new BinarySearchTree<Integer, Integer>();
	}
	
	protected void insertKeys(Integer... keys) {
		Arrays.stream(keys)
			  .forEach(key -> {
				  bst.put(key, TestUtil.computeValue(key));
			  });
	}

	protected void assertRetrievingValues(List<Integer> keys) {
		keys.stream()
			.forEach(key -> {
				Assert.assertEquals("Key not found " + key, TestUtil.computeValue(key), bst.get(key));
			});
	}

	protected void assertRetrievingValues(Integer... keys) {
		Arrays.stream(keys)
			   .forEach(key -> {
				   Assert.assertEquals("Key not found " + key, TestUtil.computeValue(key), bst.get(key));
			   });
	}
}
