package hackerrank.algorithms.sorting.countingsort;

import java.util.stream.IntStream;

public class Challenge2 {

	public static void printInSortedOrder(int[] input) {
		int[] counts = new int[100];
		
		for (int i = 0; i < input.length; i++) {
			counts[input[i]]++;
		}
		StringBuilder sortedOutput = new StringBuilder();
		for (int i = 0; i < counts.length; i++) {
			int number = i;
			int freq = counts[i];
			IntStream.range(0, freq)
					 .forEach(j -> sortedOutput.append(number).append(" "));
			
		}
		System.out.println(sortedOutput.toString());
	}

	
	
	public static void main(String[] args) {
		printInSortedOrder(new int[]{98, 4, 5, 1, 1, 2, 2, 5, 6, 5, 99, 0});
	}
}
