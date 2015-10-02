package hackerrank.warmup.java.datastructures;

import junit.framework.Assert;

import org.junit.Test;

public class HourGlass_2DArrayTest {
	
	int[][] input = {{1, 1, 1, 0, 0, 0},
					 {0, 1, 0, 0, 0, 0},
					 {1, 1 ,1, 0, 0, 0},
					 {0, 0, 2, 4, 4, 0},
					 {0, 0, 0 ,2, 0, 0},
					 {0, 0, 1, 2, 4, 0}};
	
	int[][] input1 = {{10, 1, 10, 5, 5, 5},
					  {0, 1, 0, 0, 0, 0},
					  {10, 1 ,10, 5, 5, 5},
					  {0, 0, 2, 4, 4, 0},
					  {0, 0, 0 ,2, 0, 0},
					  {0, 0, 1, 2, 4, 0}};
	
	int[][] input2 = {{1, 1, 1, 5, 5, 5},
					  {0, 1, 0, 0, 0, 0},
					  {1, 1 ,1, 5, 5, 5},
					  {0, 0, 2, 4, 4, 0},
					  {0, 0, 0 ,2, 0, 0},
					  {0, 0, 1, 2, 4, 0}};
	
	int[][] input3 = {{1, 1, 1, 5, 5, 5},
					  {0, 1, 0, 0, 0, 0},
					  {1, 1 ,1, 5, 5, 5},
					  {6, 6, 6, 4, 4, 0},
					  {0, 0, 0 ,2, 0, 0},
					  {6, 6, 6, 2, 4, 0}};
	
	int[][] input4 = {{1, 1, 1, 5, 5, 5},
					  {0, 1, 0, 0, 0, 0},
					  {1, 1 ,1, 5, 5, 5},
					  {0, 0, 2, 7, 7, 7},
					  {0, 0, 0 ,2, 0, 0},
					  {0, 0, 1, 7, 7, 7}};
	
	int[][] inputHackerRank = {{-1, -1, 0, -9, -2, -2},
							   {-2, -1, -6, -8, -2, -5},
							   {-1, -1, -1, -2, -3, -4},
							   {-1, -9, -2, -4, -4, -5},
							   {-7, -3, -3, -2, -9, -9},
							   {-1, -3, -1, -2, -4, -5}};
						
	
	
	@Test
	public void shouldComputeSumOfHourGlassStartingAtAGivenPoint() {
		Assert.assertEquals(7,  HourGlass_2DArray.computeSum(input, 0, 0));
		Assert.assertEquals(4,  HourGlass_2DArray.computeSum(input, 0, 1));
		Assert.assertEquals(19,  HourGlass_2DArray.computeSum(input, 3, 2));
		Assert.assertEquals(14,  HourGlass_2DArray.computeSum(input, 3, 3));
		
	}
	
	@Test
	public void shouldFindLargestHourglassSum() {
		Assert.assertEquals(19,  HourGlass_2DArray.largestSum(input));
	}
	
	@Test
	public void shouldFindLargestHourglassSumAtCorners() {
		Assert.assertEquals(43,  HourGlass_2DArray.largestSum(input1));
		Assert.assertEquals(30,  HourGlass_2DArray.largestSum(input2));
		Assert.assertEquals(36,  HourGlass_2DArray.largestSum(input3));
		Assert.assertEquals(42,  HourGlass_2DArray.largestSum(input4));
	}
	
	@Test
	public void shouldComputeSumOfHourGlassStartingAtAGivenPointForHackerRankInput() {
		Assert.assertEquals(-6,  HourGlass_2DArray.computeSum(inputHackerRank, 0, 0));
	}
	
	@Test
	public void hackrankInput() {
		Assert.assertEquals(-6,  HourGlass_2DArray.largestSum(inputHackerRank));
	}
	
	

}
