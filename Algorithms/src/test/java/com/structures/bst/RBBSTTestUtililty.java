package com.structures.bst;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Assert;

import com.structures.bst.RedBlackBinarySearchTree.Color;
import com.structures.bst.RedBlackBinarySearchTree.Node;
import com.utility.TestUtil;

public final class RBBSTTestUtililty {

	static Node<Integer, Integer> create(Integer key, Color link) {
		return new Node<Integer, Integer>(key, TestUtil.computeValue(key), link);
	}

	static Color randomColor() {
		if (RandomUtils.nextBoolean()) {
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

	static void verifyEquals(Node<Integer, Integer> first, Node<Integer, Integer> second) {
		Assert.assertEquals(first.key, second.key);
		Assert.assertEquals(TestUtil.computeValue(first.key), TestUtil.computeValue(second.key));
	}

	static void verifySame(Node<Integer, Integer> exp, Node<Integer, Integer> act) {
		Assert.assertSame(exp, act);
	}
}
