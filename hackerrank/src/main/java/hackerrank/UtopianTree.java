package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class UtopianTree {
	private static Predicate<Integer> isSpring = cycle -> cycle % 2 != 0; 
	private static Predicate<Integer> isSummer = isSpring.negate();
	
	private static Map<Predicate<Integer>, UnaryOperator<Integer>> criteriaToHeightComputer = new HashMap<Predicate<Integer>, UnaryOperator<Integer>>();
	static {
		criteriaToHeightComputer.put(isSpring, height -> height * 2);
		criteriaToHeightComputer.put(isSummer, height -> height + 1);
	}
	
	public int projectedHeight(int cycles) {
		return IntStream
				.range(0, cycles + 1)
				.reduce(0, (height, cycle) -> {
							return getHeightComputer(cycle).apply(height);
				});
	}
	
	private UnaryOperator<Integer> getHeightComputer(int cycle) {
		return criteriaToHeightComputer.keySet()
							.stream()
							.filter(cyclePredicate -> cyclePredicate.test(cycle))
							.map(cycePredicate -> criteriaToHeightComputer.get(cycePredicate))
							.findFirst()
							.get();
	}
}
