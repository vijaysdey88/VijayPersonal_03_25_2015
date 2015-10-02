package hackerrank.implementation;

import java.util.Scanner;

public class HolmesKey {

	private static final String KEY_NOT_FOUND = "-1";

	public static String findKey(int n) {
		if(n < 3) {
			return KEY_NOT_FOUND;
		}
		StringBuilder key = new StringBuilder();
		int n5 = n - ( n % 3);
		if(n5 == n) {
			append(key, 5, n);
			return key.toString();
		} else {
			n5 -= 3;
			while(n5 >= 0) {
				int n3 =  n - n5;
				if(n3 % 5 == 0) {
					append(key, 5, n5);
					append(key, 3, n3);
					return key.toString();
				}
				n5 -= 3;
			}
		}
		return KEY_NOT_FOUND;
	}
	
	private static void append(StringBuilder key, int digit, int times) {
		for (int i = 0; i < times; i++) {
			key.append(digit);
		}
	}


	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int T = scanner.nextInt();
//		
//		for (int i = 0; i < T; i++) {
//			int n = scanner.nextInt();
//			System.out.println(findKey(n));
//		}
//		
//		scanner.close();
		
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		int[] input = new int[len];
		for (int i = 0; i < len; i++) {
			input[i] = scanner.nextInt();
		}
		scanner.close();
	}
}
