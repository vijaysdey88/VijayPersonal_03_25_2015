package hackerrank.implementation;

import junit.framework.Assert;
import hackerrank.implementation.BdayGift.Gift;

import org.junit.Test;

public class BdayGiftTest {

	@Test
	public void shouldNotTransferWhenDirectlyBuyingItemsIsLessSpend() {
		long spend = BdayGift.minSpend(new Gift(2, 5), new Gift(3, 9), 4); 
		Assert.assertEquals(37, spend);
	}
	
	@Test
	public void shouldNotTransferWhenDirectlyBuyingItemsAndTransferLeadToEqualSpend() {
		long spend = BdayGift.minSpend(new Gift(1, 10), new Gift(1, 10), 1); 
		Assert.assertEquals(20, spend);
	}
	
	@Test
	public void shouldTransferWhenTransferingLeadsToLessSpend() {
		long spend = BdayGift.minSpend(new Gift(9, 3), new Gift(1, 6), 1); 
		Assert.assertEquals(12, spend);
	}
}
