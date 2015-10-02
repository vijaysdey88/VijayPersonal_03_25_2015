package com.temp;

import java.text.DecimalFormat;
import java.util.Collections;

public class Precision {

	public static void main(String[] args) {
		int x = 6;
		double y = 2.0;
		double ans = y / 6d;
		System.out.println(ans);
		DecimalFormat df = new DecimalFormat("###.###");
		System.out.println(df.format(y / (double)x));

		System.out.println(df.format(10000d/6));
		
		//Collections.sort(list);
		 
	}

}
