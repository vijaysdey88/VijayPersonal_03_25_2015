package hackerrank;


import hackerrank.LinkedList.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LinkedListTest {
	private LinkedList list = new LinkedList();
	
	@Before
	public void setup() {
		addElementsToList(3);
	}


	private void addElementsToList(int size) {
		createEmptyList();
		IntStream.range(0, size)
				 .forEach(list::add);
	}
	
	private void addElementsToList(int... elements) {
		createEmptyList();
		Arrays.stream(elements)
			.forEach(e -> list.add(e));
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
		createEmptyList();
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
		createEmptyList();
		list.reverseIteratively();
		Assert.assertNull(list.head);
	}
	
	@Test
	public void shouldReverseIterativelyForSingleElement() {
		createEmptyList();
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
		createEmptyList();
		list.reverseRecursively();
		Assert.assertNull(list.head);
	}
	
	@Test
	public void shouldReverseRecursivelyForSingleElement() {
		createEmptyList();
		list.add(0);
		list.reverseRecursively();
		assertElementsInList(0);
	}


	private void createEmptyList() {
		list = new LinkedList();
	}
	
	@Test 
	public void shouldReverseListUsingRecursionForManyNodes() {
		addElementsToList(5);
		list.reverseRecursively();
		assertElementsInList(4, 3, 2, 1, 0);
	}

	
	@Test
	public void removeDuplicateNodesShouldDoNothingForEmptyList() {
		createEmptyList();
		list.RemoveDuplicates(list.head);
		Assert.assertNull(list.head);
	}
	
	@Test
	public void shouldRemoveDuplicateNodesFromListAtTheBeginning() {
		addElementsToList(1, 1, 1);
		list.RemoveDuplicates(list.head);
		assertElementsInList(1);
	}
	
	@Test
	public void shouldNotRemoveIfNotDuplicateAtTheBeginning() {
		addElementsToList(1, 2);
		list.RemoveDuplicates(list.head);
		assertElementsInList(1, 2);
	}
	
	@Test
	public void shouldRemoveDuplicateElementsInTheMiddleIfTheList() {
		addElementsToList(1, 1, 2, 3, 3, 4, 4, 5);
		list.RemoveDuplicates(list.head);
		assertElementsInList(1, 2, 3, 4, 5);
	}
	
	@Test
	public void shouldDeleteMultipleDuplicateElements() {
		addElementsToList(1, 2, 2, 2, 2, 2, 3);
		list.RemoveDuplicates(list.head);
		assertElementsInList(1, 2, 3);
	}
	
	@Test
	public void shouldRemoveDuplicateElementsAtTheEnd() {
		addElementsToList(1, 1, 2, 3, 4, 5, 5, 5);
		list.RemoveDuplicates(list.head);
		assertElementsInList(1, 2, 3, 4, 5);
	}
	
	@Test
	public void shouldRemoveDuplicatesReturnHead() {
		addElementsToList(1, 1, 2, 3, 3, 4, 4, 5);
		Node temp = list.head;
		Assert.assertSame(temp, list.RemoveDuplicates(list.head));
	}
	
	private void assertElementsInList(int... expected) {
		IntStream.range(0, expected.length)
				 .forEach(i -> Assert.assertEquals("For i = " + i , expected[i], list.getNodeFromFront(i)));
	}
	
	@Test
	public void hasCycleShouldReturn0ForEmptyList() {
		createEmptyList();
		Assert.assertEquals(0, list.HasCycle(list.head));
	}
	
	@Test
	public void hasCycleShouldReturn0ForNoLoopsForOddSizedList() {
		addElementsToList(5);
		Assert.assertEquals(0, list.HasCycle(list.head));
	}
	
	@Test
	public void hasCycleShouldReturn0ForNoLoopsForEvenSizedList() {
		addElementsToList(4);
		Assert.assertEquals(0, list.HasCycle(list.head));
	}
	
	@Test
	public void hasCycleShouldDetectLoopAtHead() {
		addElementsToList(1);
		list.head.next = list.head;
		Assert.assertEquals(1, list.HasCycle(list.head));
	}
	
	@Test 
	public void hasCycleShouldDetectLoopForCircularListForOddSize() {
		addElementsToList(5);
		Node last = list.getNodeFromFront(4, list.head);
		last.next = list.head;
		Assert.assertEquals(1, list.HasCycle(list.head));
	}
	
	@Test 
	public void hasCycleShouldDetectLoopForCircularListForEvenSize() {
		addElementsToList(4);
		Node last = list.getNodeFromFront(3, list.head);
		last.next = list.head;
		Assert.assertEquals(1, list.HasCycle(list.head));
	}
	
	@Test 
	public void hasCycleShouldDetectOddSizedLoopInBetween() {
		addElementsToList(6);
		Node middle = list.getNodeFromFront(1, list.head);
		middle.next = list.head;
		Assert.assertEquals(1, list.HasCycle(list.head));
	}
	
	@Test 
	public void hasCycleShouldDetectEvenSizedLoopInBetween() {
		addElementsToList(6);
		Node middle = list.getNodeFromFront(2, list.head);
		middle.next = list.head;
		Assert.assertEquals(1, list.HasCycle(list.head));
	}
	
	@Test
	public void lengthShouldReturnNumberOfNodesInList() {
		createEmptyList();
		Assert.assertEquals(0, LinkedList.length(list.head));
		
		addElementsToList(6);
		Assert.assertEquals(6, LinkedList.length(list.head));
	}
	
	
	@Test
	public void shouldFindMergePointOfTwoLists() {
		addElementsToList(5);
		Node mergePoint = list.head.next.next; //2
		LinkedList listB = new LinkedList();
		listB.head = mergePoint;
		
		//Assert.assertEquals(2, LinkedList.FindMergeNode(list.head, listB.head));
		Assert.assertEquals(2, LinkedList.FindMergeNode(listB.head, list.head));
	}
	
}
