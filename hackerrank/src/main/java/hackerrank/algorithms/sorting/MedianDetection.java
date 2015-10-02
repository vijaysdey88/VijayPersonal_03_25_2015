package hackerrank.algorithms.sorting;

import java.util.Arrays;


public class MedianDetection {
	
	private static int median(int[] input) {
		int medianIndex = input.length / 2;
		select(input, 0, input.length-1, medianIndex);
		return input[medianIndex];
	}

	private static void select(int[] input, int lo, int hi, int medianIndex) {
		int partition = partition(input, lo, hi);
		System.out.println("Partition :" + partition + " input:" + Arrays.toString(input));
		if(partition==medianIndex)
			return;
		else if(partition > medianIndex) {
			 select(input, lo, partition - 1, medianIndex);
		} else {
			 select(input, partition + 1, hi, medianIndex);
		}
	}

	private static int partition(int[] input, int lo, int hi) {
		int pivot = input[hi];
		int i = lo;
		
		for (int j = lo; j < hi; j++) {
			if(input[j] <= pivot) {
				swap(input, i, j);
				i++;
			}
		}
		swap(input, i, hi);
		return i;
	}
	
	private static void swap(int[] input, int i1, int i2) {
		int temp = input[i1];
		input[i1] = input[i2];
		input[i2] = temp;
	}
	
	public static void main(String[] args) {
		System.out.println(median(new int[]{0,1,2,4,6,5,3}));
		
		System.out.println(median(new int[]{3,6,1,2,5,4,0}));
		
		System.out.println(median(new int[]{6, 5, 4, 3, 2, 1, 0}));

	}

}
