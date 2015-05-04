package com.structures.bst;

import java.util.List;

import org.junit.Assert;

import com.utility.TestUtil;

public abstract class BSTTestBasis {
	protected BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();

	protected void newBST() {
		bst = new BinarySearchTree<Integer, Integer>();
	}
	
	protected void insertKeys(Integer... keys) {
		for (Integer key : keys) {
			bst.put(key, TestUtil.computeValue(key));
		}
	}

	protected void assertRetrievingValues(List<Integer> keys) {
		for (Integer key : keys) {
			Assert.assertEquals("Key not found " + key, TestUtil.computeValue(key), bst.get(key));
		}
	}

	protected void assertRetrievingValues(Integer... keys) {
		for (Integer key : keys) {
			Assert.assertEquals("Key not found " + key, TestUtil.computeValue(key), bst.get(key));
		}
	}
}
