package hackerrank.algorithms.sorting.quiksort;

import org.junit.Assert;
import org.junit.Test;

public class HoarePartitionTest {
	
	@Test
	public void shouldPartitionTheArrayBySeletingLoAsPivot() {
		int[] input = {3, 4, 5, 1, 2};
		
		int p = HoarePartition.partition(input, 0, input.length-1);
		Assert.assertEquals(2, p);
		Assert.assertArrayEquals(new int[]{1,2,3,5,4}, input);
	}
	
	@Test
	public void partitionAtTheLo() {
		int[] input = {1, 2, 3, 4, 5};
		
		int p = HoarePartition.partition(input, 0, input.length-1);
		Assert.assertEquals(0, p);
		Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, input);
	}
	
	
	@Test
	public void partitionAtTheHi() {
		int[] input = {5, 1, 2, 3, 4};
		
		int p = HoarePartition.partition(input, 0, input.length-1);
		Assert.assertEquals(4, p);
		Assert.assertArrayEquals(new int[]{4,1,2,3,5}, input);
	}
	
	@Test
	public void shouldPartitionArrayOfEqualEements() {
		int[] input = {5, 5, 5, 5, 5};
		
		int p = HoarePartition.partition(input, 0, input.length-1);
		Assert.assertEquals(4, p);
		Assert.assertArrayEquals(new int[]{5, 5, 5, 5, 5}, input);
	}
	
	@Test
	public void shouldSortArray() {
		int[] input = new int[]{10, 10, 15, 3, 3, 6, 1};
		HoarePartition.sort(input);
		Assert.assertArrayEquals(new int[]{1, 3, 3, 6, 10, 10, 15}, input);
	}

}
