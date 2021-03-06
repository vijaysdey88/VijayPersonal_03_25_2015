package hackerrank.algorithms.sorting.quiksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge2 {
	
	public static void main(String[] args) {
		int[] input = {4, 5, 3, 7, 2, 0, 1, 9};
		sort(input);
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
		List<Integer> lessThanPivot = new ArrayList<Integer>();
		List<Integer> greaterThanPivot = new ArrayList<Integer>();
		
		int pivot = input[lo];
		for(int i = lo; i <= hi; i++) {
			int element = input[i];
			if(element < pivot) {
				lessThanPivot.add(element);
			} else if(element > pivot) {
				greaterThanPivot.add(element);
			}
		}

		int index = lo;
		for(Integer i : lessThanPivot) {
			input[index++] = i; 
		}
		int partitioningIndex = index;
		input[index++] = pivot;
		for(Integer i : greaterThanPivot) {
			input[index++] = i; 
		}
		
//		print(Arrays.copyOfRange(input, lo, hi+1));
		return partitioningIndex;
	}
	
	private static void print(int[] input) {
		String partitioned = Arrays.stream(input)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" "));
		System.out.println(partitioned);
	}

}
