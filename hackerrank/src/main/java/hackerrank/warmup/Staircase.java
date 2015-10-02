package hackerrank.warmup;

import java.util.Arrays;

public class Staircase {

	public static void main(String[] args) {
		int N = 6;
		char[] spaces = new char[N];
		Arrays.fill(spaces, ' ');
		StringBuilder sb = new StringBuilder(new String(spaces));
		
		for(int i = 0; i < N; i++) {
			sb.setCharAt(N - i - 1, '#');
			System.out.println(sb.toString());
		}
	}

}
