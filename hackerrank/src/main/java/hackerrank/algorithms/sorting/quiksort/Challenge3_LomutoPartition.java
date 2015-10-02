package hackerrank.algorithms.sorting.quiksort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Challenge3_LomutoPartition {
	
	
	public static void main(String[] args) {
//		int[] input = {10, 15, 3, 2, 6};
		int[] input = {1, 2, 3, 4, 6};
		int p = partition(input, 0, input.length - 1);
		System.out.println(p);
		
		input = new int[] {6, 6, 6, 6, 6, 6};
		p = partition(input, 0, input.length - 1);
		System.out.println(p);
		
		sort(new int[]{10, 15, 3, 3, 6});
		
	}
	
	private static void sort(int[] input) {
		sort(input, 0, input.length-1);
	}


	private static void sort(int[] input, int lo, int hi) {
		if(hi <= lo) {
			return;
		}
		int partition = partition(input, lo, hi);
		sort(input, lo, partition -1);
		sort(input, partition + 1, hi);
		print(Arrays.copyOfRange(input, lo, hi+1));
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
		print(Arrays.copyOfRange(input, 0, input.length));
		return i;
	}
	
	private static void swap(int[] input, int i1, int i2) {
		int temp = input[i1];
		input[i1] = input[i2];
		input[i2] = temp;
	}
	
	private static void print(int[] input) {
		String partitioned = Arrays.stream(input)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" "));
		System.out.println(partitioned);
	}
	

}
