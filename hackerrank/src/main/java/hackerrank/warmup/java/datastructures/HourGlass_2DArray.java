package hackerrank.warmup.java.datastructures;

import java.util.Arrays;

public class HourGlass_2DArray {

	public static int largestSum(int[][] input) {
		int largest = Integer.MIN_VALUE;
		for(int i = 0; i <= limit(input); i++) {
			for (int j = 0; j <= limit(input); j++) {
				HourGlass hourGlass = new HourGlass(input, i, j);
				System.out.println(hourGlass);
				int sum = hourGlass.sum();
				if(sum > largest) {
					largest = sum;
					System.out.println("largest coor - " +  i + ", " + j);
				}
			}
		}
		return largest;
	}

	private static int limit(int[][] input) {
		return input.length - 3;
	}
	
	public static int computeSum(int[][] input, int x, int y) {
		HourGlass hg = new HourGlass(input, x, y);
		return hg.sum();
	}
	
	private static final class HourGlass {
		private int x,y;
		private int[][] input;

		public HourGlass(int[][] input, int x, int y) {
			this.input = input;
			this.x = x;
			this.y = y;
		}

		public int sum() {
			int sumX1 = input[x][y] + input[x][y + 1] + input[x][y + 2];
			int sumX2 = input[x + 1][y + 1];
			int sumX3 = input[x + 2][y] + input[x + 2][y + 1] + input[x + 2][y + 2];
			return sumX1 + sumX2  + sumX3 ;
			 
		}

		@Override
		public String toString() {
			return "HourGlass [x=" + x + ", y=" + y + ", sum="
					+ sum() + "]";
		}
		
	}

	

}
