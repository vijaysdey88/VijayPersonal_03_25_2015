package hackerrank.string.easy;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Pangram {

	private static char SPACE = ' ';

	static String detectPangram(String input) {
		String result = "pangram";

		Set<Character> chars = input.chars().filter(c -> c != SPACE)
				.mapToObj(c -> Character.toLowerCase((char) c)).sorted()
				.collect(Collectors.toSet());

		System.out.println(chars);
		if (chars.size() < 26) {
			result = "not pangram";
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(detectPangram("We promptly judged antique ivory buckles for the next prize"));
		System.out.println(detectPangram("We promptly judged antique ivory buckles for the prize"));
		// int s = ' ';
		// System.out.println(s + "--" + SPACE + "--");
		// System.out.println(s == SPACE);

		Scanner sc = new Scanner(System.in);
		String input = "";
			input = sc.nextLine();
		
		System.out.println(input);
		System.out.println(detectPangram(input));
	}

}
