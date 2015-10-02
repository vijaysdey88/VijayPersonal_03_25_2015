package hackerrank;

import junit.framework.Assert;
import org.junit.Test;

public class UtopianTreeTest {

	private UtopianTree tree = new UtopianTree();
	
	@Test
	public void treeShouldBeBornWithAHieghtOf1() {
		Assert.assertEquals(1, tree.projectedHeight(0));
	}
	
	@Test
	public void shouldDoubleHeightAfterFirstSpring() {
		Assert.assertEquals(2, tree.projectedHeight(1));
	}
	
	@Test
	public void shouldAddOneMeterToHeightAfterFirstSummer() {
		Assert.assertEquals(3, tree.projectedHeight(2));
	}
	
	@Test
	public void shouldComputeHieghtForMultipleCyclesOfSpringAndSummer() {
		Assert.assertEquals("Two Spring + One Summer.", 6, tree.projectedHeight(3));
		Assert.assertEquals("Two Spring + Two Summer.", 7, tree.projectedHeight(4));
		Assert.assertEquals("Three Spring + Two Summer.", 14, tree.projectedHeight(5));
		Assert.assertEquals("Three Spring + Three Summer.", 15, tree.projectedHeight(6));
	}
}
