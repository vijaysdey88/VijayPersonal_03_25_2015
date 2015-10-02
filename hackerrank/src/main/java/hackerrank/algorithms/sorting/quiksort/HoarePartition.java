package hackerrank.algorithms.sorting.quiksort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HoarePartition {
	
	public static void sort(int[] input) {
		sort(input, 0, input.length-1);
	}
	
	private static void sort(int[] input, int lo, int hi) {
		if(hi <= lo) {
			return;
		}
		int partition = partition(input, lo, hi);
		sort(input, lo, partition -1);
		sort(input, partition + 1, hi);
		//print(Arrays.copyOfRange(input, lo, hi+1));
	}

	public static int partition(int[] input, int lo, int hi) {
		int pivot = input[lo];
		int i = lo + 1;
		int j = hi;
		while(true) {
			while((i < hi) && input[i] <= pivot)
				i++;
			
			while(input[j] > pivot) 
				j--;
			
			if(j > i) {
				swap(input, i, j);
			} else {
				break;
			}
			
		}
		swap(input, lo, j);
		print(input);
		return j;
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
