package hackerrank.warmup.java.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class JavaArray1D_JumpTest {
	
	@Test
	public void shouldCrossByJumpingOver() {
		Assert.assertEquals("YES", JavaArray1D_Jump.canCross(new int[]{0, 0, 0}, 3));
		Assert.assertEquals("YES", JavaArray1D_Jump.canCross(new int[]{0, 0, 0, 0, 0}, 2));
	}
	
	@Test
	public void shouldCrossByTakingSingleSteps() {
		Assert.assertEquals("YES", JavaArray1D_Jump.canCross(new int[]{0, 0, 0}, 0));
	}
	
	@Test
	public void shouldCrossGoAheadBySingleStepWhenCantJumpOver() {
		Assert.assertEquals("YES", JavaArray1D_Jump.canCross(new int[]{0, 0, 1}, 2));
	}
	
	@Test
	public void shouldNotCrossIfJumpLengthIsNotLongEnough() {
		Assert.assertEquals("NO", JavaArray1D_Jump.canCross(new int[]{0, 1, 1}, 1));
	}
	
	@Test
	public void singleStepShouldReturnNoWhenJumpLengthZero() {
		Assert.assertEquals("NO", JavaArray1D_Jump.canCross(new int[]{0, 0, 1}, 0));
	}
	
	@Test
	public void shouldJumpInBetweenAndCrossOver() {
		Assert.assertEquals("YES", JavaArray1D_Jump.canCross(new int[]{0, 1, 1, 0, 0}, 3));
		Assert.assertEquals("YES", JavaArray1D_Jump.canCross(new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1}, 3));
	}
	
	@Test
	public void shouldJumpInBetweenAButNotCrossOver() {
		Assert.assertEquals("NO", JavaArray1D_Jump.canCross(new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1}, 3));
	}
	
	@Test
	public void testHackerRankInputInSubmitCode1() {
		//		1
		//		9 4
		//0 1 1 0 0 1 1 0 1
		Assert.assertEquals("YES", JavaArray1D_Jump.canCross(new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1}, 4));
	}

	@Test
	public void testHackerRankInputsInTestRun() {
		//		1
		//		9 4
		//0 1 1 0 0 1 1 0 1
		Assert.assertEquals("NO", JavaArray1D_Jump.canCross(new int[]{0, 0, 1, 1, 1, 0}, 3));
	}
	
	@Test
	public void testHackerRankInput() {
		
	}
}
