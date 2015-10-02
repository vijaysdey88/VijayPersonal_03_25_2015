package hackerrank.implementation;

import junit.framework.Assert;
import org.junit.Test;

public class HolmesKeyTest {

	
	@Test 
	public void shouldReturnNoKeyFoundForOneThrough2Digits() {
		Assert.assertEquals("-1", HolmesKey.findKey(1));
		Assert.assertEquals("-1", HolmesKey.findKey(2));
	}
	
	@Test
	public void shouldBeAll5sWhenDigitsCountDivisibleByThree() {
		Assert.assertEquals("555", HolmesKey.findKey(3));
		Assert.assertEquals("555555", HolmesKey.findKey(6));
		Assert.assertEquals("555555555", HolmesKey.findKey(9));
		Assert.assertEquals("555555555555555", HolmesKey.findKey(15));
	}
	
	
	
	
	@Test
	public void shouldBeAll3sWhenDigitsCountCantHave5ButIsDivisibleBy5() {
		Assert.assertEquals("33333", HolmesKey.findKey(5));
		Assert.assertEquals("3333333333", HolmesKey.findKey(10));
	}
	
	
	@Test
	public void shouldHaveMax5sFollowedBy3s() {
		Assert.assertEquals("55533333", HolmesKey.findKey(8));
		Assert.assertEquals("55555533333", HolmesKey.findKey(11));
		Assert.assertEquals("5555553333333333", HolmesKey.findKey(16));
		Assert.assertEquals("55555555555555533333", HolmesKey.findKey(20));
	}
	
	@Test
	public void shouldReturnNoKeyFoundWhenCantAccommodat5sAnd3s() {
		Assert.assertEquals("-1", HolmesKey.findKey(7));
		
	}
}
