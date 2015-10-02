package hackerrank.algorithms.strings;

public class AlternatingCharacters {

	private static long alternateCharacters(String input) {
		long noOfDeletions = 0;
		char prevChar = input.charAt(0);
		for(int i = 1; i < input.length(); i++) {
			char current = input.charAt(i);
			if(prevChar == current) {
				noOfDeletions++;
			} else {
				prevChar = current;
			}
		}
		return noOfDeletions;
	}
	
	public static void main(String[] args) {
		System.out.println(alternateCharacters("BBBBBAA"));
		System.out.println(alternateCharacters("ABABABAB"));
		System.out.println(alternateCharacters("BABABA"));
		System.out.println(alternateCharacters("AAABBB"));
	}
}
