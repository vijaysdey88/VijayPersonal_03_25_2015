package hackerrank.warmup.java.datastructures;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LargestRectangeTest {
	
	@Test
	public void shouldFindLargestRectangleForSingleElement() {
		Assert.assertEquals(1, LargestRectange.find(new int[]{1}));
		Assert.assertEquals(3, LargestRectange.find(new int[]{3}));
	}

	@Test
	public void shouldFindLargestRectangleForTwoElements() {
		Assert.assertEquals(2, LargestRectange.find(new int[]{1, 2}));
	}
	
	
	@Test
	public void shouldFindLargestRectangleWhenHeightsInOrder() {
		Assert.assertEquals(9, LargestRectange.find(new int[]{1, 2, 3, 4, 5}));
	}
	
	//This may not be needed
	@Test @Ignore
	public void shouldFindLargestRectangleWhenHeightsUnorderedBySorting() {
		Assert.assertEquals(9, LargestRectange.find(new int[]{1, 4, 2, 3, 5}));
	}
	
	@Test 
	public void shouldFindLargestRectangleWhenHeightsUnordered() {
		Assert.assertEquals(9, LargestRectange.find(new int[]{1, 4, 2, 3, 5}));
	}
	
	@Test
	public void shouldFindLargestRectangleForNonConsecutiveInputs() {
		Assert.assertEquals(200, LargestRectange.find(new int[]{2, 5, 8, 10, 15, 35}));
	}
}
