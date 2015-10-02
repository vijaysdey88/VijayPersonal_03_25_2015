package com.structures.pq;

public interface PriorityQueue<T extends Comparable<T>> {

	public void insert(T item);
	
	public T remove();
	
	public int size();
}
