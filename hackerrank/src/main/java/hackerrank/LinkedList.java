package hackerrank;

public class LinkedList {
	Node head;
	
	public LinkedList add(int value) {
		Node newNode = new Node(value, null);
		if(null == head) {
			head = newNode;
		} else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		return this;
	}
	
	public int getNodeFromFront(int n) {
		Node node = head;
		
		while(n > 0 && node != null) {
			node = node.next;
			--n;
		}
		
		if(node == null) 
				throw new IndexOutOfBoundsException("Index invalid - " + n); 
		return node.data;
	}
	
	/*
	 * Insert Node at the end of a linked list head pointer input could be NULL
	 * as well for empty list Node is defined as class Node { int data; Node
	 * next; }
	 */
	int getNodeFromBack(Node head, int n) {
		// This is a "method-only" submission.
		// You only need to complete this method.

		Node node = getIndexFromBack(head, new Counter(n));
		return node.data;
	}

	Node getIndexFromBack(Node node, Counter c) {
		Node matched = null;
		if (node == null) {
			matched = null;
		} else {
			matched = getIndexFromBack(node.next, c);
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

	public void reverseIteratively() {
		if (head != null) {
			Node previous = null;
			Node current = head;
			Node next = head.next;
			while (null != next) {
				current.next = previous;
				Node temp = next.next;
				next.next = current;

				previous = current;
				current = next;
				next = temp;
			}
			head = current;
		}
	}

	public void reverseRecursively() {
		if(null != head)
			head = reverseRecursively(head);
	}
	
	private Node reverseRecursively(Node node) {
		if(node.next == null) {
			return node;
		} else {
			Node newHead = reverseRecursively(node.next);
			Node next = node.next;
			next.next = node;
			node.next = null;
			return newHead;
		}
	}


}
