package hackerrank;


import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
	private LinkedList ll = new LinkedList();
	
	@Test
	public void getNthNodeFromBackShouldReturnTheCorrectNode() {
		ll.add(0).add(1).add(2);
		
		Assert.assertEquals(2, ll.getNodeFromBack(ll.head, 0));
		Assert.assertEquals(1, ll.getNodeFromBack(ll.head, 1));
		Assert.assertEquals(0, ll.getNodeFromBack(ll.head, 2));
		
	}
}
