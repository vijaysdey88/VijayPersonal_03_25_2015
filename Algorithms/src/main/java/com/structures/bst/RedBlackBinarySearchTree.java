package com.structures.bst;

import com.common.Utility;

public class RedBlackBinarySearchTree<K extends Comparable<K>, V> {

	Node<K, V> root;

	public void put(K key, V value) {
		root = put(root, key, value);

	}

	private Node<K, V> put(Node<K, V> node, K key, V value) {
		if (null == node) {
			return new Node<K, V>(key, value, Color.RED);
		}
		int c = Utility.compare(key, node.key);
		if (c < 0) {
			node.left = put(node.left, key, value);
		} else if (c > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}

		if (!isRed(node.left) && isRed(node.right)) {
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left) && !isRed(node.right)) {
			node = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right)) {
			flipColors(node);
		}
		return node;
	}

	boolean isRed(Node<K, V> node) {
		return (null != node) && (node.link == Color.RED);
	}

	static class Node<K, V> {
		K key;
		V value;
		Node<K, V> left;
		Node<K, V> right;
		Color link;

		public Node(K key, V value, Color link) {
			this.key = key;
			this.value = value;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}

	}

	enum Color {
		RED, BLACK
	}

	Node<K, V> rotateLeft(Node<K, V> node) {
		Node<K, V> x = node.right;
		node.right = x.left;
		x.left = node;
		x.link = node.link;
		node.link = Color.RED;
		return x;
	}

	Node<K, V> rotateRight(Node<K, V> node) {
		Node<K, V> x = node.left;
		node.left = x.right;
		x.right = node;
		x.link = node.link;
		node.link = Color.RED;
		return x;
	}

	void flipColors(Node<K, V> node) {
		node.link = Color.RED;
		node.left.link = Color.BLACK;
		node.right.link = Color.BLACK;
	}

	public V get(K key) {
		Node<K, V> node = get(root, key);
		return (null != node) ? node.value : null;
	}

	private Node<K, V> get(Node<K, V> node, K key) {
		if (null == node) {
			return null;
		}

		int c = Utility.compare(key, node.key);
		if (c < 0) {
			return get(node.left, key);
		} else if (c > 0) {
			return get(node.right, key);
		} else {
			return node;
		}
	}

}
