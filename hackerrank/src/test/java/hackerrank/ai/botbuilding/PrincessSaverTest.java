package hackerrank.ai.botbuilding;

import hackerrank.ai.botbuilding.PrincessSaver.Coordinate;
import hackerrank.ai.botbuilding.PrincessSaver.Matrix;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.collect.Lists;

public class PrincessSaverTest {
	
	private String[] input1 = {
		"---", "-m-", "p--"
	};
	
	private String[] input2 = {
			"p---", "----", "---m", "----"
		};

	@Test
	public void shouldDetectCoordinatesOfPrincessAndSaviour() {
		Matrix matrix = new Matrix(input1);
		Assert.assertEquals(new Coordinate(1, 1), matrix.saviourCoordinate);
		Assert.assertEquals(new Coordinate(2, 0), matrix.princessCoordinate);
		
		matrix = new Matrix(input2);
		Assert.assertEquals(new Coordinate(2, 3), matrix.saviourCoordinate);
		Assert.assertEquals(new Coordinate(0, 0), matrix.princessCoordinate);
	}
	
	@Test
	public void shouldComputeDistanceBetweenPrincessAndSaviour() {
		Matrix matrix = new Matrix(input1);
		Assert.assertEquals(new Coordinate(1, -1), matrix.distanceBetweenSaviourAndPrincess());
		
		matrix = new Matrix(input2);
		Assert.assertEquals(new Coordinate(-2, -3), matrix.distanceBetweenSaviourAndPrincess());
	}
	
	@Test
	public void findPathFromSaviourToPrincessForInput1() {
		Matrix matrix = new Matrix(input1);
		List<String> expPath = Lists.newArrayList("DOWN", "LEFT");
		Assert.assertEquals(expPath, matrix.findPath());
		
	}
	
	@Test
	public void findPathFromSaviourToPrincessForInput2() {
		Matrix matrix = new Matrix(input2);
		List<String> expPath = Lists.newArrayList("UP", "UP", "LEFT", "LEFT", "LEFT");
		Assert.assertEquals(expPath, matrix.findPath());
		
	}
}
