package hackerrank.algorithms.greedy;

import junit.framework.Assert;

import org.junit.Test;

public class FlowersPurchaseTest {

	@Test
	public void shouldBuyOneFlowerEach() {
		Integer[] costs = {2, 5, 6};
		int persons = 3;
		
		Assert.assertEquals(13, FlowersPurchase.getMinCost(persons, costs));
	}
	
	@Test
	public void shouldBuyCostliestFlowersFirstToGetMinCost() throws Exception {
		Integer[] costs = {2, 5, 6};
		int persons = 2;
		
		Assert.assertEquals(15, FlowersPurchase.getMinCost(persons, costs));
	}

}
