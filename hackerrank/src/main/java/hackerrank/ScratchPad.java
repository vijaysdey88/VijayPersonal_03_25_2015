package hackerrank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ScratchPad {

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("1000000000000000000000000000000", 2));
		
		
		for(int i = 10; i >= -10; i--){
			System.out.println(Integer.toBinaryString(i));
		}
		
		IntStream.range(0, 1)
		.forEach(i -> System.out.println(">"));
		
		/*int[] arr = new int[1];
		System.out.println(Arrays.toString(arr));
		int i = arr[0]++;
		System.out.println(i);
		System.out.println(Arrays.toString(arr));
		
		Integer[] arr1 = new Integer[]{0};
		arr1[0]++; // arr1[0] = arr1[0] + 1;
		System.out.println(Arrays.toString(arr1));*/
		
	}

}
