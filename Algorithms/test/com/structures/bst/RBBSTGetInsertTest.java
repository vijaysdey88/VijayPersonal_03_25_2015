package com.structures.bst;

import static com.utility.TestUtil.computeValue;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

import com.structures.bst.RedBlackBinarySearchTree.Color;
import com.structures.bst.RedBlackBinarySearchTree.Node;
import com.utility.TestUtil;
public class RBBSTGetInsertTest {

	private RedBlackBinarySearchTree<Integer, Integer> bst = new RedBlackBinarySearchTree<Integer, Integer>();

	@Test
	public void putShouldInsertAtNewNodeAtRootWithRedLink() {
		Integer key = 10;
		bst.put(key, computeValue(key));

		assertNode(key, Color.RED, bst.root);
	}

	@Test
	public void putShouldInsertNewNodeAtLeftOfRoot() {
		bst.put(10, computeValue(10));
		int key = 5;
		bst.put(key, computeValue(key));

		assertNode(key, Color.RED, bst.root.left);
	}

	@Test
	public void putShouldInsertNewNodeAtRightAndRotateLeft() {
		bst.put(10, computeValue(10));
		int key = 15;
		bst.put(key, computeValue(key));

		assertNode(key, Color.RED, bst.root);
		assertNode(10, Color.RED, bst.root.left);
		Assert.assertNull(bst.root.right);
		assertLeafNode(bst.root.left);
	}

	@Test
	public void shouldInsertLeftChildToA3NodeAtRoot() {
		bst.put(10, computeValue(10));
		bst.put(5, computeValue(5));
		bst.put(2, computeValue(2));
		
		// RotateRight at 10 - FilpColors at 5
		assertNode(5, Color.RED, bst.root);
		assertNode(2, Color.BLACK, bst.root.left);
		assertNode(10, Color.BLACK, bst.root.right);
	}

	@Test
	public void shouldInsertNodeInMiddleOf3NodeAtRoot() {
		bst.put(10, computeValue(10));
		bst.put(5, computeValue(5));
		bst.put(7, computeValue(7));

		// RotateLeft at 5 - RotateRight at 10 - FlipColors at 5
		assertNode(7, Color.RED, bst.root);
		assertNode(5, Color.BLACK, bst.root.left);
		assertNode(10, Color.BLACK, bst.root.right);
	}

	@Test
	public void shouldReplaceAnAlreadyExistingValue() {
		bst.put(10, computeValue(10));

		Integer newValue = RandomUtils.nextInt();
		bst.put(10, newValue);

		Assert.assertEquals(newValue, bst.root.value);
	}

	@Test
	public void getShouldRetrieveAllElementsOfTree() {
		Integer[] keys = { 10, 8, 15, 17, 2, 1, 20 };
		insertKeys(keys);
		assertRetrievingValues(keys);
	}

	@Test
	public void getShouldReturnNullForKeyNotFound() {
		insertKeys(10, 8, 15, 17, 2, 1, 20);
		Assert.assertNull(bst.get(200));
	}

	@Test
	public void testGetPutForRandomKeys() {
		Random random = new Random();
		Integer[] keys = random.ints(50).boxed().toArray(Integer[]::new);
		insertKeys(keys);
		
		assertRetrievingValues(keys);
	}

	private void assertLeafNode(Node<Integer, Integer> leafNode) {
		Assert.assertNull(leafNode.left);
		Assert.assertNull(leafNode.right);
	}

	private void assertNode(Integer key, Color expectedLink, Node<Integer, Integer> node) {
		Assert.assertNotNull("Node not inserted", node);
		Assert.assertEquals(key, node.key);
		Assert.assertEquals(computeValue(key), node.value);
		Assert.assertEquals(expectedLink, node.link);
	}

	private void insertKeys(Integer... keys) {
		Arrays.stream(keys)
		      .forEach(key -> bst.put(key, TestUtil.computeValue(key)));
	}

	private void assertRetrievingValues(Integer... keys) {
		Arrays.stream(keys)
			  .forEach(key -> Assert.assertEquals("Key not found " + key, TestUtil.computeValue(key), bst.get(key)));
	}

}
