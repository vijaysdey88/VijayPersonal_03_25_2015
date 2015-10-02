package hackerrank.algorithms.sorting.quiksort;

import java.util.Arrays;

public class Challenge4_SortingTime {
	
	private static class QuickSort {
		int swapsCount = 0;
		private final int[] input;
		
		public QuickSort(int[] input) {
			super();
			this.input = input;
		}
		
		private int sort() {
			sort(input, 0, input.length-1);
			return swapsCount;
		}


		private void sort(int[] input, int lo, int hi) {
			if(hi <= lo) {
				return;
			}
			int partition = partition(input, lo, hi);
			sort(input, lo, partition -1);
			sort(input, partition + 1, hi);
		}



		private int partition(int[] input, int lo, int hi) {
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
		
		private void swap(int[] input, int i1, int i2) {
			swapsCount++;
			int temp = input[i1];
			input[i1] = input[i2];
			input[i2] = temp;
		}		
	}
	
	
	public static void main(String[] args) {
		int[] input = {1,3,9,8,2,7,5};
		System.out.println(new QuickSort(input).sort());
	}

}
