package hackerrank.algorithms.search;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/pairs
public class DifferencePairs {
	
	private static int diffCount(int[] input, int diff) {
		int count = 0;
		Arrays.sort(input);
		for (int i = 0; i < input.length; i++) {
			int ith = input[i];
			for (int j = i + 1; j < input.length; j++) {
				int pairDiff = Math.abs(ith -  input[j]);
				if(pairDiff == diff) {
					count++;
				} else if (pairDiff > diff) {
					break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(diffCount(new int[]{1, 5, 3, 4, 2}, 2));
	}

}
