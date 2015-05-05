package hackerrank;

public class MaxXOrFinder {

	public static int maxXor(int l, int r) {
		validateInputRange(l);
		validateInputRange(r);
		int result = 0;

		for (int i = l; i < r; i++) {
			for (int j = i + 1; j <= r; j++) {
				int xor = i ^ j;
				if (xor > result) {
					result = xor;
				}
			}
		}
		return result;
	}

	private static void validateInputRange(int num) {
		if (num < 1 || num > 1000) {
			throw new IllegalArgumentException();
		}
	}

}
