package com.structures.hashing;

public final class HashFunction {

	public static final HashFunction INSTANCE = new HashFunction();
	
	private HashFunction() {
	}

	public int hash(Object key, int max) {
		return (key.hashCode() & 0x7fffffff) % max;
	}
	

}
