package hackerrank.warmup.java.datastructures;

import java.util.Iterator;

public final class JavaArray1D {

	public static void main(String[] args) {
		int[] input = { 1, -2, 4, -5, 1 };
		System.out.println(findNegativeSubArrayCount(input));
	}

	private static int findNegativeSubArrayCount(int[] input) {
		int negSubArrCnt = 0;
		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			for (int j = i; j < input.length; j++) {
				sum = sum + input[j];
				if(sum < 0) {
					negSubArrCnt++;
					System.out.println("neg - [" + i + "," + j + "]");
				}
			}
		}
		return negSubArrCnt;
	}

}
