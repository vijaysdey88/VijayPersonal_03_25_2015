package com.temp;

import java.util.Arrays;

public class Temp {

	static int[] longestSequence(int[] seq) {
		Arrays.sort(seq);
		Sequence longest = new Sequence(0);
		Sequence current = new Sequence(0);
		
		for (int i = 1; i < seq.length; i++) {
			if(seq[i] - seq[i - 1] == 1 ){
				current.increment();
			} else {
				if(current.length() > longest.length()) {
					longest = current;
				}
				current = new Sequence(i);
			}
		}
		//Check if the last sequence is longest
		if(current.length() > longest.length()) {
			longest = current;
		}
		
		int[] result = new int[longest.length()];
		if(longest.length() > 0) {
			int resultIndex = 0;
			for (int i = longest.startIndex; i <= longest.endIndex; i++) {
				result[resultIndex] = seq[i];
				resultIndex++;
				
			}
		}
		return result;
    }
	
	private static class Sequence {
		int startIndex;
		int endIndex;
		
		public Sequence(int startIndex) {
			this.startIndex = startIndex;
			this.endIndex = startIndex;
		}

		int length() {
			if(startIndex == endIndex) 
				return 0;
			return endIndex - startIndex + 1;
		}
		
		void increment() {
			endIndex++;
		}
	}
	
	public static void main(String[] args) {
		int[] seq = {2, 22, 23, 1,  3, 24, 25, 26, 27};
		System.out.println(Arrays.toString(longestSequence(seq)));
		
		int[] seq1 = {};
		System.out.println(Arrays.toString(longestSequence(seq1)));
	}

}
