package com.structures.pq;

import com.common.Utility;

/**
 * 
 * @author deyv
 *
 * @param <T>
 */
public class LinkedListBasedOrderedMaxPQ<T extends Comparable<T>> implements PriorityQueue<T>  {
	
	private Node<T> head;
	private int size;

	//Maintains an ordered linked list with the max element as the head 
	@Override
	public void insert(T item) {
		Node<T> node = head;
		head = insert(node, item);
	}

	private Node<T> insert(Node<T> node, T item) {
		Node<T> newNode =  createNewNode(item);
		if(null == node) {
			return newNode;
		}
		
		if(Utility.lessThan(node.data, item)) {
			newNode.next = node;
			node = newNode;
		} else {
			node.next = insert(node.next, item);
		}
		return node;
	}

	private Node<T> createNewNode(T item) {
		size++;
		return new Node<T>(item);
	}

	@Override
	public T remove() {
		if(null == head) {
			return null;
		}
		T data = head.data;
		head = head.next;
		size--;
		return data;
	}

	@Override
	public int size() {
		return size;
	}

	private static class Node<T> {
		private final T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	


}
