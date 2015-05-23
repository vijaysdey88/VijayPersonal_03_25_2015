package hackerrank;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class UtopianTree {
	private Predicate<Integer> isSpring = cycle -> cycle % 2 != 0; 

	public int projectedHeight(int cycles) {
		return IntStream
				.range(0, cycles + 1)
				.reduce(0, (height, cycle) -> {
							return getHeightComputer(cycle).apply(height);
				});
	}
	
	private Function<Integer, Integer> getHeightComputer(int cycle) {
		if(isSpring.test(cycle)) {
			return height -> height * 2;
		} else {
			return height -> height + 1;
		}
	}
}
