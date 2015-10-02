package hackerrank.algorithms.sorting.countingsort;


public class Challenge3 {

	public static void printLessThanEqualCount(int[] input) {
		int[] counts = new int[100];
		for (int i = 0; i < input.length; i++) {
			counts[input[i]]++;
		}
		StringBuilder sortedOutput = new StringBuilder();
		int elementsLessThanEqualTo = 0;
		for (int i = 0; i < counts.length; i++) {
			elementsLessThanEqualTo += counts[i];
			sortedOutput.append(elementsLessThanEqualTo).append(" ");
		}
		System.out.println(sortedOutput.toString());
	}

	
	
	public static void main(String[] args) {
		printLessThanEqualCount(new int[]{98, 4, 5, 1, 1, 2, 2, 5, 6, 5, 99, 10, 10, 0});
	}

}
