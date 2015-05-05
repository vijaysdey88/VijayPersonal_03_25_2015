package com.common;

public class Utility {

	public static <T extends Comparable<T>> int compare(T first, T second) {
		return first.compareTo(second);
	}

	public static <T extends Comparable<T>> boolean greaterThan(T first, T second) {
		return first.compareTo(second) > 0;
	}

	public static <T extends Comparable<T>> boolean lessThan(T first, T second) {
		return first.compareTo(second) < 0;
	}
	
	public static <T extends Comparable<T>> boolean greaterThanEqualTo(T first, T second) {
		return first.compareTo(second) >= 0;
	}

	public static <T extends Comparable<T>> boolean lessThanEqualTo(T first, T second) {
		return first.compareTo(second) <= 0;
	}
	
	public static <T extends Comparable<T>> boolean between(T lo, T hi, T value) {
		return lessThanEqualTo(lo, value) && greaterThanEqualTo(hi, value);
	}
	
	
	public static <T extends Comparable<T>> boolean equals(T first, T second) {
		return first.compareTo(second) == 0;
	}

}
