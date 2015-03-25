package com.structures.bst;

import com.common.Utility;

public class BinarySearchTree<K extends Comparable<K>, V> {
	private Node<K, V> root;

	void put(K key, V value) {
		root = put(root, key, value);
	};

	private Node<K, V> put(Node<K, V> node, K key, V value) {
		if (null == node) {
			return new Node<K, V>(key, value);
		}
		int c = Utility.compare(key, node.key);
		if (c > 0) {
			node.right = put(node.right, key, value);
		} else if(c < 0) {
			node.left = put(node.left, key, value);
		} else {
			node.value = value;
		}
		return node;
	}

	V get(K key) {
		Node<K, V> node = root;
		while (null != node) {
			int c = Utility.compare(key, node.key);
			if (c == 0) {
				return node.value;
			} else if (c > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
	};

	private static class Node<K, V> {
		private K key;
		private V value;

		private Node<K, V> left;
		private Node<K, V> right;

		private Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
	}
}
