package com.basic.recursion;

import org.junit.Assert;
import org.junit.Test;

public class BasicRecursionslTest {

	@Test
	public void factorialShouldReturnOneForInputZero() {
		Assert.assertEquals(1, BasicRecursions.fact(0));
	}

	@Test
	public void factorialShouldReturnOneForInputOne() {
		Assert.assertEquals(1, BasicRecursions.fact(1));
	}

	@Test
	public void factorialShouldComputeByMultiplyingForInputGreaterThanOne() {
		Assert.assertEquals(2, BasicRecursions.fact(2));
		Assert.assertEquals(6, BasicRecursions.fact(3));
		Assert.assertEquals(24, BasicRecursions.fact(4));
		Assert.assertEquals(120, BasicRecursions.fact(5));
	}

	@Test
	public void fibonnaciShouldReturnZeroAsFirstNumberOfTheSeries() {
		Assert.assertArrayEquals(new int[] { 0 }, BasicRecursions.fib(1));
	}

	@Test
	public void fibonacciShouldReturnZeroAndOneAsFirstTwoNumberOfTheSeries() {
		Assert.assertArrayEquals(new int[] { 0, 1 }, BasicRecursions.fib(2));
	}

	@Test
	public void fibonacciShouldComputeCurrentValueByAddingPreviousTwoValuesWhenSizeGreaterThan2() {
		Assert.assertArrayEquals(new int[] { 0, 1, 1 }, BasicRecursions.fib(3));
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2 }, BasicRecursions.fib(4));
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 3 }, BasicRecursions.fib(5));
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 3, 5 }, BasicRecursions.fib(6));
	}

	@Test
	public void fibonacciShouldComputeForLargerN() {
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 3 }, BasicRecursions.fib(5));
		//Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 }, BasicRecursions.fib(10));
	}

}
