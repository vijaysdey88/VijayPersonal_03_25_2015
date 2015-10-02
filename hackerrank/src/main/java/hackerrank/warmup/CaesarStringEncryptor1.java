package hackerrank.warmup;


public class CaesarStringEncryptor1 {
	
	public static String encrypt(String input, int k) {
		char[] chars = input.toCharArray();
		char[] encrypted = new char[chars.length];
		k = k % 26;
		for (int i = 0; i < chars.length; i++) {
			encrypted[i] = encrypt(chars[i], k);
		}
		return new String(encrypted);
	}
	

	private static char encrypt(char ch, int k) {
		if(!Character.isAlphabetic(ch)) {
			return ch;
		}
		char start = 'a';
		char end = 'z';
		if(Character.isUpperCase(ch)) {
			 start = 'A';
			 end = 'Z';
		}
		int encrypted = ch + k;
		if(encrypted > end) {
			encrypted = start + (encrypted - end) - 1;
		}
		return (char)encrypted;
	}


	public static void main(String[] args) {
		String input = "abcdz-12-ZA";
		System.out.println(encrypt(input, 2));
	}
}

