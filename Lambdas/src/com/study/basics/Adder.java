package com.study.basics;

public interface Adder<T> {
	
	T add(T x, T y);
	
	public static void main(String[] args) {
		
		Adder<String> stringAdder = (x,y) -> "Concated - " + x.concat(y);
		System.out.println(stringAdder.add("Hip", "Hop"));
		
		System.out.println(((Adder<Integer>)(x,y) -> x + y).add(123, 3423));
	}

}
