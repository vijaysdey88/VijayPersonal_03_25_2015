package hackerrank.warmup;

public class CaesarStringEncryptor {
	
	public static String encrypt(String input, int k) {
		k = k % 26;
		byte[] chars = input.getBytes();
		byte[] encrypted = new byte[chars.length];
		
		for(int i = 0; i < chars.length; i++) {
			encrypted[i] = encryptChar(chars[i], k);
		}
	
		return new String(encrypted);
	}
	
	static byte encryptChar(byte input, int k) {
		int encrypted = input;
		if(isAlphabetic(input)) {
			encrypted = input + k;
			
			if(isLowerCase(input) && encrypted > 122) {
				encrypted = (97 + (encrypted % 122) - 1);
			} else if(isUpperCase(input) && encrypted > 90) {
				encrypted = (65 + (encrypted % 90) - 1);
			}
			
		}
		return (byte)encrypted;
	}
	
	
	private static boolean isAlphabetic(byte input) {
		return isLowerCase(input) || isUpperCase(input);
	}

	private static boolean isLowerCase(byte input) {
		return input >= 97 && input <= 122;
	}
	
	private static boolean isUpperCase(byte input) {
		return input >= 65 && input <= 90;
	}

	public static void main(String[] args) {
		String input = "abcdz-12-ZA";
		System.out.println(encrypt(input, 25));
	}
}

