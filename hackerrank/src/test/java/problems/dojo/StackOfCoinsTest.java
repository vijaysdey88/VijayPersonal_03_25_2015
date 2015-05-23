package problems.dojo;

import java.util.stream.IntStream;

import junit.framework.Assert;

import org.junit.Test;

public class StackOfCoinsTest {
	
	private StackOfCoins stack = new StackOfCoins();
	
	@Test
	public void shouldReturnZeroForZeroCoinsAtTheBase() {
		Assert.assertEquals(0, stack.count(0));
	}
	
	@Test
	public void shouldReturnOneForOneCoinsAtTheBase() {
		Assert.assertEquals(1, stack.count(1));
	}
	
	@Test
	public void countOfCoinsForTwoIsTwoPlusCountForBaseOne() {
		Assert.assertEquals(3, stack.count(2));
	}
	
	@Test
	public void shouldReturnCountForAllNumbers() {
		int[] expected = {0, 1, 3, 6, 10, 15, 21, 28, 36, 45};
		
		IntStream.range(0, 10)
				 .forEach(i -> Assert.assertEquals(expected[i], stack.count(i)));
		
	}

}
