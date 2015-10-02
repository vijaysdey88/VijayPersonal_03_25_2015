package hackerrank.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//https://www.hackerrank.com/challenges/closest-numbers
public class ClosestNumbers {
	
	public static void closestNumbers(int[] input) {
		Arrays.sort(input);
		
		List<Pair> minPairs = new ArrayList<Pair>();
		int minDiff = Integer.MAX_VALUE;
		
		for (int i = 0; i < input.length - 1; i++) {
			Pair pair = new Pair(input[i], input[i+1]);
			int diff = pair.diff();
			if (diff < minDiff) {
				minPairs = new ArrayList<Pair>();
				minPairs.add(pair);
				minDiff = diff;
			} else if (diff == minDiff) {
				minPairs.add(pair);
			}
		}
		
		String output = minPairs.stream()
								.map(Pair::toString)
								.collect(Collectors.joining(" "));
		System.out.println(output);
		
	}
	
	private static class Pair {
		int n1;
		int n2;
		public Pair(int n1, int n2) {
			this.n1 = n1;
			this.n2 = n2;
		}
		
		int diff() {
			 return Math.abs(n1 - n2);
		}

		@Override
		public String toString() {
			return n1 + " " + n2;
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MAX_VALUE-1 * 2);
//		System.out.println(new Pair(-Integer.MAX_VALUE, 3).diff());
		
		System.out.println(new Pair(-20, 30).diff());
		System.out.println(new Pair(6246457, 7374819).diff());
		
		int[] input = {5,4,3,2};
		//closestNumbers(input);
		
		closestNumbers(new int[]{-20,-3916237,-357920,-3620601,7374819,-7330761,30,6246457,-6461594,266854,-520,-470,});
	}

}
