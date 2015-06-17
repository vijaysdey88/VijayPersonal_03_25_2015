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
		Node found = getNodeFromFront(n, node);
		if(found == null) 
			throw new IndexOutOfBoundsException("Index invalid - " + n); 
		return found.data;
	}

	Node getNodeFromFront(int n, Node node) {
		while(n > 0 && node != null) {
			node = node.next;
			--n;
		}
		return node;
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

	public Node RemoveDuplicates(Node head) {
		removeDuplicatesRecursively(head);
		return head;
		
	}

	private void removeDuplicatesRecursively(Node node) {
		if (node == null || node.next == null) {
			return;
		}
		if (node.data == node.next.data) {
			node.next = node.next.next;
			removeDuplicatesRecursively(node);
		} else {
			removeDuplicatesRecursively(node.next);
		}
	}
	
	int HasCycle(Node head) {
		Node slow = head;
		Node fast = head == null ? null : head.next;
		
		while(slow != null && fast != null && fast.next!=null) {
			if(slow == fast)
				return 1;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return 0;
	}

	public static int FindMergeNode(Node headA, Node headB){
		int lenA = length(headA);
		int lenB = length(headB);
		int diffLen = lenA - lenB;
		if(diffLen < 0) {
			Node temp = headA;
			headA = headB;
			headB = temp;
		}
		
		for(int i = 0; i < Math.abs(diffLen); i++) {
			headA = headA.next;
		}
		
		while(headA!=null && headB!=null) {
			if(headA == headB) 
				return headA.data;
			
			headA = headA.next;
			headB = headB.next;
		}
		//Not found!!!
		return -1;
	}

	protected static int length(Node head) {
		int len = 0;
		while(head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
