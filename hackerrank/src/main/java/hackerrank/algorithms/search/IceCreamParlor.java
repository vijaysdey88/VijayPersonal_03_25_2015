package hackerrank.algorithms.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlor {
	
	private static class FlavorsFinder {
		final int sumOfAmount;
		final Map<Integer, Integer> flavorPriceToIndex = new HashMap<Integer, Integer>();
		boolean foundPairs = false;

		public FlavorsFinder(int sumOfAmount) {
			this.sumOfAmount = sumOfAmount;
		}

		public void printFlavorsIfFound(int flavorPrice, int flavorIndex) {
			int matchingFlavor = sumOfAmount - flavorPrice;
			if(flavorPriceToIndex.containsKey(matchingFlavor)) {
				
				if (!foundPairs) {
					System.out.println("" + (flavorPriceToIndex.get(matchingFlavor) + 1) + " " + (flavorIndex + 1));
					foundPairs = true;
				}
			}
			flavorPriceToIndex.put(flavorPrice, flavorIndex);
		}
	}
	
	public static void printFlavors(int sum, int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if(input[i] + input[j] == sum) {
					System.out.println("" + (i + 1) + " " + (j + 1));
					break;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] prices = new int[] { 1, 4, 5, 3, 2 };
		int sumOfAmount = 4;
		printFlavors(sumOfAmount, prices);
		prices = new int[] { 2, 2, 4, 3 };
		sumOfAmount = 4;
		printFlavors(sumOfAmount, prices);
		
//		Scanner scanner = new Scanner(System.in);
//		int T = scanner.nextInt();
//
//		for (int i = 0; i < T; i++) {
//			System.out.println("Test case start - " + i);
//			int sum = scanner.nextInt();
//			FlavorsFinder finder = new FlavorsFinder(sum);
//			int flavorsCount = scanner.nextInt();
//			for (int j = 0; j < flavorsCount; j++) {
//				int flavorPrice = scanner.nextInt();
//				finder.printFlavorsIfFound(flavorPrice, j);
//			}
//			System.out.println("Test case end - " + i);
//		}
//
//		scanner.close();
	}

}
