package hackerrank.algorithms.sorting.countingsort;

import java.util.Arrays;

public class Challenge4 {
	
	public static void printWithAssociatedData(int[] input, String[] dataArr) {
		CountWithData[] counts = new CountWithData[100];
		
		for (int i = 0; i < input.length; i++) {
			String data = dataArr[i];
			if(i < input.length/2) {
				data = "-";
			}
			
			CountWithData.add(counts, input[i], data);
		}
		StringBuilder sortedOutput = new StringBuilder();
		Arrays.stream(counts)
			  .forEach(cwd -> {
				  if (null != cwd) {
					sortedOutput.append(cwd.data.toString()).append(" ");
				}
			  });
		System.out.println(sortedOutput.toString());
	}

	private static class CountWithData {
		@SuppressWarnings("unused")
		int count;
		StringBuilder data;
		
		public CountWithData(int count, String data) {
			this.count = count;
			this.data = new StringBuilder(data);
		}

		public static void add(CountWithData[] counts, int index, String data) {
			CountWithData cwd = counts[index];
			if(null ==  cwd) {
				counts[index] = new CountWithData(1, data);
			} else {
				cwd.count++;
				cwd.data.append(" ").append(data); 
			}
		}
	}

	public static void main(String[] args) {
		printWithAssociatedData(new int[]{1, 98, 4, 5, 1, 1},
								new String[]{"z", "ab", "cd", "dd", "rr", "xx"}
				);
	}
}
