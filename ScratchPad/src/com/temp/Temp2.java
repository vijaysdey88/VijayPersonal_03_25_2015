package com.temp;

public class Temp2 {

	
	static int partition (int sum, int max)
	{
	    if (sum == max)
	        return 1 + partition(sum, max - 1);
	    if (max == 0 || sum < 0)
	        return 0;
	    if (sum == 0 || max == 1)
	        return 1;

	    return partition(sum, max - 1) + partition(sum - max, max);

	}
	
	public static void main(String[] args) {
		System.out.println(partition(4, 4));
	}
}
