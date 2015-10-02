package com.basic.recursion;



public class BasicRecursions {

	/**
	 * Factorial
	 * n! = n * (n-1)!
	 * 0! = 1
	 */
	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}

	static int[] fib(int len) {
		int[] output = new int[len];

		for (int i = 0; i < output.length; i++) {
			System.out.println("Computing fib(" + i + ")");
			output[i] = fibRecursively(i);
		}
		return output;
	}

	// Inefficient takes exponential time!!!
	private static int fibRecursively(int n) {
		System.out.println("fibRecursively(" + n + ")");
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibRecursively(n - 1) + fibRecursively(n - 2);
		}

	}

}
