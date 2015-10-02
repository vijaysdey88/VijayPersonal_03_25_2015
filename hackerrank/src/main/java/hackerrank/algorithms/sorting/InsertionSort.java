package hackerrank.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort {

	private static void insertIntoSorted(int[] ar) {
		int i = ar.length - 1;
		int itemToBeInserted = ar[i];

		int j;
		for (j = i; j > 0; j--) {
			if (itemToBeInserted < ar[j - 1]) {
				ar[j] = ar[j - 1];
				printArray(ar);
			} else {
				break;
			}
		}
		ar[j] = itemToBeInserted;
		printArray(ar);

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void insertionSortPart2(int[] ar) {
		for (int i = 1; i < ar.length; i++) {
			int itemToBeInserted = ar[i];
			int j = i;
			while (j > 0 && (itemToBeInserted < ar[j - 1])) {
				ar[j] = ar[j - 1];
				j--;
			}
			ar[j] = itemToBeInserted;
 			printArray(ar);
		}
	} // private static String print(int[] input) {

	// return Arrays.stream(input)
	// .mapToObj(i -> Integer.toString(i))
	// .collect(Collectors.joining(" "));
	//
	// }

	public static void main(String[] args) {
		// insertIntoSorted(new int[]{2, 4, 6, 8, 3});

		insertionSortPart2(new int[] { 2, 4, 6, 8, -1, -20 });
	}
}
