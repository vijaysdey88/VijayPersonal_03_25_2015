package hackerrank.algorithms.bitmanipulation;

public class FlippingBits {

	private static void printFlippedInt(long input) {
        input = input & 0x00000000ffffffffl;
        input = ~input;
        input = input & 0x00000000ffffffffl;
        System.out.println(input);
    }
	
	public static void main(String[] args) {
		
		printFlippedInt(2147483647);
		
//		String input = "1";
//		int unsigned = Integer.parseUnsignedInt(input);
//		int signed = Integer.parseInt(input);
//		System.out.println("Signed : " + Integer.toBinaryString(signed));
//		System.out.println("Unsigned :" + Integer.toBinaryString(unsigned));
//		System.out.println(Integer.toUnsignedLong(~unsigned));
		
//		int i1 = 1;
//		int i1_flipped = ~i1;
//		System.out.println("input - " + i1);
//		System.out.println(Long.toBinaryString(i1));
//		System.out.println(Long.toBinaryString(i1_flipped));
//		System.out.println(i1_flipped);
//		System.out.println(Integer.toUnsignedString(i1_flipped));
//		
		
		

	}

}
