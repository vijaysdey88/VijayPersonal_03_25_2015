package hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;


public class FlowersPurchase {

	public static int getMinCost(int personCount, Integer[] costs) {
		int perheadFlowersBought = 0;
		Arrays.sort(costs, Comparator.reverseOrder());
		int totalCost  = 0;
		for (int i = 1; i <= costs.length; i++) {
			int flowerCost = (perheadFlowersBought + 1) * costs[i-1];
			totalCost+=flowerCost;
			if(0 == i%personCount) {
				perheadFlowersBought++;
			}
		}
		return totalCost;
	}
}
