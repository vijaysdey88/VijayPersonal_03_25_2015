package hackerrank;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ServiceLane {

	private static Map<Integer, Integer> widthByLargestVehicle = new HashMap<Integer, Integer>();
	static {
		widthByLargestVehicle.put(1, 1); // only bike
		widthByLargestVehicle.put(2, 2); // bike + car
		widthByLargestVehicle.put(3, 3); // bike + car + truck
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int serviceLaneCount = scanner.nextInt();
		int testCasesCount = scanner.nextInt();
		int[] widths = new int[serviceLaneCount];
		for (int i = 0; i < serviceLaneCount; i++) {
			widths[i] = scanner.nextInt();
		}
		
		int[] result = new int[testCasesCount];
		for(int i = 0; i < testCasesCount; i++) {
			int startLane = scanner.nextInt();
			int endLane = scanner.nextInt();
			result[i] = findLargestVehicle(widths, startLane, endLane);
		}
		
		IntStream.of(result)
				.forEach(i -> System.out.println(i));
				
		scanner.close();
	}

//	@Test
//	public void testForSampleInput() {
//		int[] widths = new int[]{2, 3, 1, 2, 3, 2, 3, 3};
//		Assert.assertEquals(1, findLargestVehicle(widths, 0, 3));
//		Assert.assertEquals(2, findLargestVehicle(widths, 4, 6));
//		Assert.assertEquals(3, findLargestVehicle(widths, 6, 7));
//	}
	
	private static int findLargestVehicle(int[] widths, int startLane, int endLane) {
		int largest = 3; //Car
		for (int i = startLane; i <= endLane; i++) {
			int currentLaneLargest = widthByLargestVehicle.get(widths[i]);
			if(currentLaneLargest < largest) {
				largest = currentLaneLargest;
			}
		}
		return largest;
	}

}
