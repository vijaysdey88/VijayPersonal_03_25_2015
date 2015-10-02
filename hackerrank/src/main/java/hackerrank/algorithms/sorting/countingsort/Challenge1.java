package hackerrank.algorithms.sorting.countingsort;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Challenge1 {
	
	public static void printFrequencies(Integer[] input) {
		Map<Integer, Integer> numberToFrequency = new HashMap<Integer, Integer>();
		for(Integer i : input) {
			Integer freq = getFreqIfExists(i, numberToFrequency);
			numberToFrequency.put(i, (freq + 1));
		}
		String frequencyOutput = IntStream.range(0, 100)
										  .boxed()
										  .map(i -> getFreqIfExists(i, numberToFrequency).toString())
										  .collect(Collectors.joining(" "));
		System.out.println(frequencyOutput);
		
	}

	private static Integer getFreqIfExists(Integer number, Map<Integer, Integer> numberToFrequency) {
		Integer freq = numberToFrequency.get(number);
		if(null == freq) {
			freq = 0;
		}
		return freq;
	}
	
	public static void main(String[] args) {
		printFrequencies(new Integer[]{1, 1, 2, 2, 5, 6, 5, 99, 0});
	}

}
