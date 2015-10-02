package hackerrank.string.easy;

public class FunnyString {

	/**
	 * @param input
	 * @return
	 */
	static String detechFunnyString(String input) {
		String result = "Funny";
		char[] chars = input.toCharArray();
		int reverseIndex = chars.length -  1;
		for (int forwardIndex = 0; forwardIndex < (chars.length / 2); forwardIndex++) {
			int forwardDiff = Math.abs(chars[forwardIndex] - chars[forwardIndex+1]);
			int reverseDiff = Math.abs(chars[reverseIndex] - chars[reverseIndex-1]);
			if(forwardDiff != reverseDiff) {
				result = "Not Funny";
				break;
			}
			reverseIndex--;
		}
		
		return result;
	}

	public static void main(String[] args) {
		String str = "bcxz";
		System.out.println(detechFunnyString(str));
	}
}
