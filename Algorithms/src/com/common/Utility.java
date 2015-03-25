package com.common;

public class Utility {

	public static <T extends Comparable<T>> int compare(T first, T second) {
		return first.compareTo(second);
	}

	public static <T extends Comparable<T>> boolean greaterThan(T first, T second) {
		return first.compareTo(second) > 0;
	}

	public static <T extends Comparable<T>> boolean equals(T first, T second) {
		return first.compareTo(second) == 0;
	}

}
