package hackerrank.algorithms.sorting;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/sherlock-and-watson
public class SherlockAndWatson {
	
	
	private static void rotateCircular(int[] input, int times) {
		int offset = 0;
		
		for (int i = 0; i < times; i++) {
			int next = input[offset];
			for (int j = offset; j < input.length; j= j+times) {
				int nextIndex = nextIndex(times, j, input.length);
				int temp = input[nextIndex];
				input[nextIndex] = next;
				next = temp;
			}
			offset++;
		}
	}

	private static int nextIndex(int times, int j, int length) {
		int nextIndex = j + times;
		if(nextIndex >= length) {
			nextIndex = nextIndex - length ;
		}
		return nextIndex;
	}

	public static void main(String[] args) {
		// 0 1 2 3 4 5
		int[] input = new int[] {1, 2, 3};//[2, 3, 1]. 
		rotateCircular(input, 2);
		System.out.println(Arrays.toString(input));

	}

}
