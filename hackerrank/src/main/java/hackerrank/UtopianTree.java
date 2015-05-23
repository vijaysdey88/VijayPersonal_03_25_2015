package hackerrank;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class UtopianTree {
	private Predicate<Integer> isSpring = cycle -> cycle % 2 != 0; 
	private Function<Integer, Function<Integer, Integer>> getHeightComputer =
				(cycle) -> {
					if(isSpring.test(cycle)) {
						return current -> current * 2;
					} else {
						return current -> current + 1;
					}
				};

	public int projectedHeight(int cycles) {
		return IntStream
				.range(0, cycles + 1)
				.reduce(0, (height, cycle) -> {
							return getHeightComputer.apply(cycle)
													.apply(height);
				});
	}
}
