package hackerrank.warmup.java.datastructures;

import java.util.Arrays;

public class LargestRectange {

	public static int find(int[] input) {
		int[] ordered = Arrays.copyOf(input, input.length);
		//Arrays.sort(ordered);
		int maxRectArea = 0;
		for (int i = 0; i < ordered.length; i++) {
			int height = ordered[i];
			int length = ordered.length - i;
			int area = height * length;
			
			if(area > maxRectArea) 
				maxRectArea = area;
		}
		
		return maxRectArea;
	}
	
	

}
