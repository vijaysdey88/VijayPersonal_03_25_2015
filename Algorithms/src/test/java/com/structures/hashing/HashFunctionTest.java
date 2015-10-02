package com.structures.hashing;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class HashFunctionTest {

	private HashFunction hf = HashFunction.INSTANCE;

	@Test
	public void shouldHaveASingletonInstance() {
		Assert.assertNotNull(hf);
		Assert.assertSame(hf, HashFunction.INSTANCE);
	}

	@Test
	public void shouldComputeHashFunctionForIndexingMSizedArray() {
		int M = 100;
		String key = RandomStringUtils.random(5);
		
		int hash = hf.hash(key, M);
		
		int expected = (key.hashCode() & 0x7fffffff) % M;
		Assert.assertEquals(expected, hash);
	}
	
	
	@Test
	public void shouldBeAbleToStoreMaxPositiveIntegerKey() {
		int M = 128;
		Integer key = Integer.MAX_VALUE;
		
		Assert.assertEquals(127, hf.hash(key, M));
	}
	
	@Test
	public void shouldBeAbleToStoreMaxNegativeIntegerKey() {
		int M = 128;
		Integer key = Integer.MIN_VALUE;
		
		Assert.assertEquals(0, hf.hash(key, M));
	}
	
	@Test public void scratchPad() {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		System.out.println("Binary min - "  + min + " - "+ Integer.toBinaryString(min));
		System.out.println("Binary max - "  + max + " - "+ Integer.toBinaryString(max));
		System.out.println("Binary 0x7fffffff - " + Integer.toBinaryString(0x7fffffff));
		
		System.out.println("Removing sign min - " + (min & 0x7fffffff));
		System.out.println("Removing sign max - " + (max & 0x7fffffff));
		
		Assert.assertEquals("min = " + min, 0, (min & 0x7fffffff));
		Assert.assertEquals("max = " + max, 2147483647, (max & 0x7fffffff));
	}
}
