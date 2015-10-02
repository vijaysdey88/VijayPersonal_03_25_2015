package hackerrank.warmup.java.datastructures;

public class JavaArray1D_Jump {

	/**
	 * @param input
	 * @param jumpLength
	 * @return
	 */
	/**
	 * @param input
	 * @param jumpLength
	 * @return
	 */
	public static String canCross(int[] input, int jumpLength) {
		String canJump = "YES";
		
		int currentPosition = 0;
		for (int i = 0; i < input.length; i++) {
			int nextPosition = currentPosition + (jumpLength == 0 ? 1 : jumpLength);
			
			if(nextPosition >= input.length) {
				break;
			}
			
			if(input[nextPosition] == 1) {
				//Try to single step ahead
				nextPosition = currentPosition + 1;
				if(input[nextPosition] == 1) {
					//Try to back track by one step and retry
					if((currentPosition - 1) > 0 && input[currentPosition-1] == 0) {
						currentPosition--;
						continue;
					}
					
					canJump = "NO";
					break;
				}
			}
			
			currentPosition = nextPosition;
		}
		return canJump;
	}

}
