package hackerrank;

public class DoublyLinkedList {

	Node head;

	Node SortedInsert(Node head, int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (null == head) {
			head = newNode;
		} else if (head.data > newNode.data) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else {
			Node current = head;

			while (current != null) {
				if (current.data > newNode.data) {
					current = current.prev;
					break;
				} else if(current.next == null) {
					break;
				}
				current = current.next;
			}

			Node temp = current.next;
			current.next = newNode;
			newNode.prev = current;
			if(null != temp) {
				newNode.next = temp;
				temp.prev = newNode;
			}

		}

		this.head = head;
		return head;
	}
	
	/**
	 * @param head
	 * @return
	 */
	public Node Reverse(Node head) {
		if(null == head) return null;
		
		Node newHead = Reverse(head.next);
		Node next = head.next;
		//Return Last node as head
		if(null == next)  {
			head.prev = null;
			return head;
		}
		head.prev = next;
		next.next = head;
		head.next = null;
		this.head = newHead;
		return newHead;
	}

	private Node sortedInsertRecursively(Node head, Node current, Node newNode) {
		if (null == head) {
			return newNode;
		}

		if (head.data > newNode.data) {
			newNode.next = head;
			head.prev = newNode;
			return newNode;
		}

		if (current.next == null) {
			current.next = newNode;
			newNode.prev = current;
			return head;
		}
		head = sortedInsertRecursively(head, head.next, newNode);
		return head;
	}

	class Node {
		int data;
		Node next;
		Node prev;
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
		
	}

}
