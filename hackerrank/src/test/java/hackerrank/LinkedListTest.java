package hackerrank;


import hackerrank.LinkedList.Node;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LinkedListTest {
	private LinkedList list = new LinkedList();
	
	@Before
	public void setup() {
		addElementsToList(3);
	}


	private void addElementsToList(int size) {
		list = new LinkedList();
		IntStream.range(0, size)
				 .forEach(list::add);
	}
	
	@Test
	public void shouldAddNodesInorderOfInsertion() {
		Node node = list.head;
		int i = 0;
		while(node != null) {
			Assert.assertEquals(i, node.data);
			i++;
			node = node.next;
		}
	}
	
	@Test
	public void getNthNodeFromBackShouldReturnTheCorrectNode() {
		Assert.assertEquals(2, list.getNodeFromBack(list.head, 0));
		Assert.assertEquals(1, list.getNodeFromBack(list.head, 1));
		Assert.assertEquals(0, list.getNodeFromBack(list.head, 2));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getNodeFromFrontShouldThrowExceptionWhenListIsEmpty() {
		list = new LinkedList();
		list.getNodeFromFront(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getNodeFromFrontShouldThrowExceptionForOutOfBoundsIndex() {
		list.getNodeFromFront(5);
	}
	
	
	@Test
	public void getNthNodeFromFront() {
		IntStream.range(0, 3)
				 .forEach(i -> Assert.assertEquals(i, list.getNodeFromFront(i)));
	}
	
	@Test
	public void shouldNotReverseIterativelyForEmpty() {
		list = new LinkedList();
		list.reverseIteratively();
		Assert.assertNull(list.head);
	}
	
	@Test
	public void shouldReverseIterativelyForSingleElement() {
		list = new LinkedList();
		list.add(0);
		list.reverseIteratively();
		assertElementsInList(0);
	}
	
	@Test
	public void shouldReverseListUsingIterationForManyNodes() {
		addElementsToList(5);
		list.reverseIteratively();
		assertElementsInList(4, 3, 2, 1, 0);
	}
	
	

	@Test
	public void shouldNotReverseRecursivelyForEmpty() {
		list = new LinkedList();
		list.reverseRecursively();
		Assert.assertNull(list.head);
	}
	
	@Test
	public void shouldReverseRecursivelyForSingleElement() {
		list = new LinkedList();
		list.add(0);
		list.reverseRecursively();
		assertElementsInList(0);
	}
	
	@Test 
	public void shouldReverseListUsingRecursionForManyNodes() {
		addElementsToList(5);
		list.reverseRecursively();
		assertElementsInList(4, 3, 2, 1, 0);
	}

	private void assertElementsInList(int... expected) {
		IntStream.range(0, expected.length)
				 .forEach(i -> Assert.assertEquals("For i = " + i , expected[i], list.getNodeFromFront(i)));
	}
	
	
	
	
}
