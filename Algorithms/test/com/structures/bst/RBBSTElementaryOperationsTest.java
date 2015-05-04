package com.structures.bst;


import static com.structures.bst.RBBSTTestUtililty.create;
import static com.structures.bst.RBBSTTestUtililty.randomColor;
import static com.structures.bst.RBBSTTestUtililty.verifySame;

import org.junit.Assert;
import org.junit.Test;

import com.structures.bst.RedBlackBinarySearchTree.Color;
import com.structures.bst.RedBlackBinarySearchTree.Node;

public final class RBBSTElementaryOperationsTest {

	private RedBlackBinarySearchTree<Integer, Integer> bst = new RedBlackBinarySearchTree<Integer, Integer>();

	@Test
	public void isRedShouldIndicateIfItsNodeHasRedLinkToParent() {
		Node<Integer, Integer> node = create(10, Color.RED);
		Assert.assertTrue(bst.isRed(node));

		node.link = Color.BLACK;
		Assert.assertFalse(bst.isRed(node));

		node = null;
		Assert.assertFalse("", bst.isRed(node));
	}

	@Test
	public void shouldRotateNodeToLeftFor3Node() {
		Color node1OriginalColor = randomColor();
		Node<Integer, Integer> node1 = create(10, node1OriginalColor);
		Node<Integer, Integer> node2 = create(15, Color.RED);
		Node<Integer, Integer> node3 = create(8, Color.BLACK);
		Node<Integer, Integer> node4 = create(12, Color.BLACK);
		Node<Integer, Integer> node5 = create(17, Color.BLACK);

		node1.left = node3;
		node1.right = node2;
		node2.left = node4;
		node2.right = node5;

		Node<Integer, Integer> node = bst.rotateLeft(node1);
		verifySame(node2, node);
		Assert.assertEquals("Same as original color of node1", node1OriginalColor, node2.link);
		verifySame(node1, node2.left);
		verifySame(node5, node2.right);

		Assert.assertEquals("Red link shifted to left", Color.RED, node1.link);
		verifySame(node3, node1.left);
		verifySame(node4, node1.right);
	}

	@Test
	public void shouldRotateNodeToRightFor3Node() {
		Color node1OriginalColor = randomColor();
		Node<Integer, Integer> node1 = create(10, node1OriginalColor);
		Node<Integer, Integer> node2 = create(5, Color.RED);
		Node<Integer, Integer> node3 = create(2, Color.BLACK);
		Node<Integer, Integer> node4 = create(7, Color.BLACK);
		Node<Integer, Integer> node5 = create(15, Color.BLACK);

		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;


		Node<Integer, Integer> node = bst.rotateRight(node1);
		verifySame(node2, node);
		Assert.assertEquals("Same as original color of node1", node1OriginalColor, node2.link);
		verifySame(node3, node2.left);
		verifySame(node1, node2.right);

		Assert.assertEquals("Red link shifted to left", Color.RED, node1.link);
		verifySame(node4, node1.left);
		verifySame(node5, node1.right);
	}

	@Test
	public void shouldFlipColorToSplit4NodeIntoTwo2Nodes() {
		Node<Integer, Integer> node1 = create(15, Color.BLACK);
		Node<Integer, Integer> node2 = create(10, Color.RED);
		Node<Integer, Integer> node3 = create(20, Color.RED);
		Node<Integer, Integer> node4 = create(5, Color.BLACK);
		Node<Integer, Integer> node5 = create(12, Color.BLACK);
		Node<Integer, Integer> node6 = create(13, Color.BLACK);
		Node<Integer, Integer> node7 = create(22, Color.BLACK);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		bst.flipColors(node1);
		Assert.assertEquals("Should change to RED", Color.RED, node1.link);
		Assert.assertEquals("Same change to BLACK", Color.BLACK, node2.link);
		Assert.assertEquals("Same change to BLACK", Color.BLACK, node3.link);
	}
}
