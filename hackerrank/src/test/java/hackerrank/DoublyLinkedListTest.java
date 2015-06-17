package hackerrank;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import hackerrank.DoublyLinkedList.Node;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class DoublyLinkedListTest {
	
	private DoublyLinkedList list = new DoublyLinkedList();
	
	@Test
	public void shouldInsertFirstNodeToTheHead() {
		int data = new Random().ints().findFirst().getAsInt();
		
		Node head = list.SortedInsert(list.head, data);
		Assert.assertSame(list.head, head);
		Assert.assertEquals(data, head.data);
		Assert.assertNull(head.next);
		Assert.assertNull(head.prev);
	}
	
	@Test 
	public void shouldInsertSecondDataToNextPositionOfHead() {
		insertData(0, 1);
		assertNode(list.head, 0);
		assertNode(list.head.next, 1);
	}
	
	@Test 
	public void shouldInsertMultipleElementsInOrder() {
		insertData(0, 1, 2);
		assertNode(list.head, 0);
		assertNode(list.head.next, 1);
		assertNode(list.head.next.next, 2);
	}
	
	@Test
	public void shouldAddElementInBetweenToKeepListSorted() {
		insertData(0, 3);
		insertData(1);
		assertNode(list.head, 0);
		assertNode(list.head.next, 1);
		assertNode(list.head.next.next, 3);
	}
	
	@Test
	public void shouldInsertSecondDataBeforeHead() {
		insertData(1, 0);
		assertNode(list.head, 0);
		assertNode(list.head.next, 1);
	}
	
	@Test
	public void reverseShouldDoNothingForEmptyList() {
		list.Reverse(list.head);
		Assert.assertNull(list.head);
	}
	
	@Test
	public void reverseShouldDoNothingForSingleElementList() {
		insertData(0);
		list.Reverse(list.head);
		
		assertNode(list.head, 0, -1, -1);
	}
	
	@Test 
	public void shouldReverse2ElememtsLinkedList() {
		insertData(0, 1);
		
		list.Reverse(list.head);
		
		assertNode(list.head, 1, -1, 0);
		assertNode(list.head.next, 0, 1, -1);
	}
	
	@Test 
	public void shouldReverseLinkedList() {
		insertData(0, 1, 2);
		
		list.Reverse(list.head);
		
		assertNode(list.head, 2, -1, 1);
		assertNode(list.head.next, 1, 2, 0);
		assertNode(list.head.next.next, 0, 1, -1);
	}

	private void assertNode(Node node, int current, int prev, int next) {
		assertNode(node, current);
		assertNode(node.prev, prev);
		assertNode(node.next, next);
	}
	
	private void assertNode(Node node, int expData) {
		if(expData == -1) {
			Assert.assertNull(node);
		} else {
			Assert.assertEquals(expData, node.data);
		}
	}

	private void insertData(int...data) {
		Arrays.stream(data)
			  .forEach(i -> list.SortedInsert(list.head, i));
	}

}
