package com.study.multithreading;

public class ThreadHelper {

	public static void sleep(int milliSecs) {
		try {
			Thread.sleep(milliSecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
