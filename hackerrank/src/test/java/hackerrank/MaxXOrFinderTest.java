package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class MaxXOrFinderTest {

	@Test
	public void firstNumberShouldBeInRangeOf1to1000() {
		shouldFailForInputs(0, 500);
		shouldFailForInputs(1001, 500);
	}

	@Test
	public void secondNumberShouldBeInRangeOf1to1000() {
		shouldFailForInputs(500, 0);
		shouldFailForInputs(500, 1001);
	}

	@Test
	public void maxXorOfSameNumbersShouldBeZero() {
		Assert.assertEquals(0, MaxXOrFinder.maxXor(10, 10));
	}

	@Test
	public void shouldXorToFindMaxResultForTwoConsecutiveNumbers() {
		Assert.assertEquals(1, MaxXOrFinder.maxXor(10, 11));
	}

	@Test
	public void shouldFindMaxXOrResultByCheckingAllNumbersBetweenInputs() {
		Assert.assertEquals(7, MaxXOrFinder.maxXor(10, 12));
		Assert.assertEquals(7, MaxXOrFinder.maxXor(10, 15));
		Assert.assertEquals(15, MaxXOrFinder.maxXor(1, 10));
	}

	private void shouldFailForInputs(int x, int y) {
		try {
			MaxXOrFinder.maxXor(x, y);
			Assert.fail("Should have thrown exception for invalid input.");
		} catch (IllegalArgumentException e) {
		}
	}

}
