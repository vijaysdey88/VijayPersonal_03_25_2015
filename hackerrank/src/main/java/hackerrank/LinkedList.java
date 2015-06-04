package hackerrank;

public class LinkedList {
	
	Node head;
	Node tail;
	
	public LinkedList add(int value) {
		Node node = new Node(value, null);
		if(null == head) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		return this;
	}
	
	/*
	 * Insert Node at the end of a linked list head pointer input could be NULL
	 * as well for empty list Node is defined as class Node { int data; Node
	 * next; }
	 */
	int getNodeFromBack(Node head, int n) {
		// This is a "method-only" submission.
		// You only need to complete this method.

		Node node = GetIndexFromBack(head, new Counter(n));
		return node.data;
	}

	Node GetIndexFromBack(Node node, Counter c) {
		Node matched = null;
		if (node == null) {
			matched = null;
		} else {
			matched = GetIndexFromBack(node.next, c);
			if (c.count == -1) {
				matched = node;
			}
		}
		c.decrement();
		return matched;
	}

	private static class Counter {
		int count;
		Counter(int count) {
			this.count = count;
		}

		void decrement() {
			this.count = this.count - 1;
		}
	}
	
	class Node {
		int data;
		Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head  + "]";
	}
}
