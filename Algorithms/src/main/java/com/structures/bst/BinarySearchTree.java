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

		resizeNode(node);
		return node;
	}

	V get(K key) {
		Node<K, V> node = get(root, key);
		if (null != node)
			return node.value;
		else
			return null;
	}

	private Node<K, V> get(Node<K, V> node, K key) {
		while (null != node) {
			int c = Utility.compare(key, node.key);
			if (c == 0) {
				return node;
			} else if (c > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return node;
	};

	private static class Node<K, V> {
		private K key;
		private V value;
		private int size = 1;

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

	public K min() {
		Node<K, V> node = min(root);
		if (null == node)
			return null;
		else
			return node.key;
	}

	private Node<K, V> min(Node<K, V> node) {
		if (null == node)
			return null;

		if (null == node.left)
			return node;
		else
			return min(node.left);
	}

	public int size(K key) {
		return size(get(root, key));
	}

	private int size(Node<K, V> node) {
		if (null == node)
			return 0;
		else
			return node.size;

	}

	public int size() {
		return size(root);
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node<K, V> deleteMin(Node<K, V> node) {
		if (null == node) {
			return null;
		}
		if (null == node.left) {
			return node.right;
		} else {
			node.left = deleteMin(node.left);
			resizeNode(node);
		}
		return node;
	}


	public void delete(K key) {
		root = delete(root, key);
	}

	private Node<K, V> delete(Node<K, V> node, K key) {
		if (null == node) {
			return null;
		}
		int c = Utility.compare(key, node.key);
		if (c < 0) {
			node.left = delete(node.left, key);
		} else if (c > 0) {
			node.right = delete(node.right, key);
		} else {
			/**
			if ((null != node.left) && (null == node.right))
				node = node.left;
			else if ((null == node.left) && (null != node.right))
				node = node.right;
			else if ((null != node.left) && (null != node.right)) {
				Node<K, V> min = min(node.right);
				deleteMin(node.right);
				min.left = node.left;
				min.right = node.right;
				node = min;
			} else {
				node = null;
			}
			**/
			if (node.right == null)
				return node.left;
			Node<K, V> min = min(node.right);
			min.right = deleteMin(node.right);
			min.left = node.left;
			node = min;
		}
		resizeNode(node);
		return node;
	}

	private void resizeNode(Node<K, V> node) {
		node.size = 1 + size(node.left) + size(node.right);
	}
}
