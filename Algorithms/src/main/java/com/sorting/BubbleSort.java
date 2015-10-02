package com.sorting;

import java.util.Arrays;

import static com.common.Utility.*;

public class BubbleSort {

	public static <T extends Comparable<T>> void sort(T[] input) {
		for (int i = 0; i < input.length; i++) {
			int j = 1;
			while (j < (input.length - i)) {
				if (lessThan(input[j], input[j - 1])) {
					//System.out.println("swap [" + j + "," + (j - 1) + "]");
					swap(input, j, j - 1);
				}

				j++;
			}
			System.out.println("Pass " + i + " - " + Arrays.toString(input));
		}
	}
	
	public static <T extends Comparable<T>> void sort1(T[] input) {
		for (int i = 0; i < input.length; i++) {
			int j = input.length - 1;
			while (j > i) {
				if (lessThan(input[j], input[j - 1])) {
					//System.out.println("swap [" + j + "," + (j - 1) + "]");
					swap(input, j, j - 1);
				}

				j--;
			}
			System.out.println("Pass " + i + " - " + Arrays.toString(input));
		}
	}

	public static void main(String[] args) {
		System.out.println("Sort ");
		sort(new Integer[] { 6, 4, 1, -7, 8, 0, 5 });
		
		System.out.println("Sort 1");
		sort1(new Integer[] { 6, 4, 1, -7, 8, 0, 5 });
		// sort(new Integer[] { 10, 9, 8, 7, 6, 5 });
		// sort(new Integer[] { 0, 0, 0 });
	}

}
