package com.structures.bst;

import static com.common.Utility.compare;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V>  {
	private Node<K, V> root;

	public void put(K key, V value) {
		root = put(root, key, value);
	};

	private Node<K, V> put(Node<K, V> node, K key, V value) {
		if (null == node) {
			Node<K,V> newNode = new Node<K, V>(key, value);
			newNode.count++;
			return newNode;
		}
		int c = compare(key, node.key);
		if (c > 0) {
			node.right = put(node.right, key, value);
		} else if (c < 0) {
			node.left = put(node.left, key, value);
		} else {
			node.value = value;
		}
		node.count = computeSize(node);
		return node;
	}

	public V get(K key) {
		Node<K,V> node = get(key, root);
		return (null != node) ? node.value : null;
	}

	private Node<K, V> get(K key, Node<K, V> node) {
		while (null != node) {
			int c = compare(key, node.key);
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

	public V floor(K key) {
		Node<K, V> node = root;
		return floor(node, key);
	}

	private V floor(Node<K, V> node, K key) {
		if (null == node) {
			return null;
		}
		int c = compare(key, node.key);
		if (c == 0) {
			return node.value;
		} else if (c < 0) {
			return floor(node.left, key);
		} else {
			V value = floor(node.right, key);
			if (null == value) {
				return node.value;
			} else {
				return value;
			}
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

	public K max() {
		return max(root);
	}

	private K max(Node<K, V> node) {
		return (null == node.right) ? node.key : max(node.right);
	}
	
	public int size() {
		return size(root);
	}
	
	protected int size(K key) {
		Node<K,V> node = get(key, root);
		return size(node);
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
		int c = compare(key, node.key);
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
		node.count = 1 + size(node.left) + size(node.right);
	}

	
	private int size(Node<K, V> node) {
		return (null != node) ? node.count : 0;
	}
	
	private int computeSize(Node<K, V> node) {
		return 1 + size(node.right) + size(node.left);
	}

	private static class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> left;
		private Node<K, V> right;
		//Number of nodes in the subtree
		private int count;

		private Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
	}

	public int rank(K key) {
		Node<K,V> node = root;
		return rank(node, key);
	}

	private int rank(Node<K, V> node, K key) {
		if(null == node) return 0;
		int c = compare(key, node.key);
		if(c == 0) {
			return size(node.left);
		} else if(c < 0) {
			return rank(node.left, key);
		} else {
			return 1 + size(node.left) + rank(node.right, key);
		}
	}

	public Iterable<K> getKeys() {
		Queue<K> queue = new LinkedList<K>();
		Node<K,V> node = root;
		insertInQueue(node, queue);
		return queue;
	}

	private void insertInQueue(Node<K, V> node, Queue<K> queue) {
		if(null == node) return;
		
		insertInQueue(node.left, queue);
		queue.add(node.key);
		insertInQueue(node.right, queue);
	}

	public int rangeCount(K lo, K hi) {
		if (null != get(lo))
			return rank(lo) - rank(hi) + 1;
		else
			return rank(lo) - rank(hi);
	}
}
