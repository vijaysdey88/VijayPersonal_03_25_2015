package com.study.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServicePractice {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService exectuorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {
			int threadNo = i;
			exectuorService.submit(() -> {
				ThreadHelper.sleep(10);
				System.out.println("Running thread + " + threadNo);
			});
		}

		ThreadHelper.sleep(5);
		//exectuorService.shutdownNow();
		exectuorService.shutdown();
		//exectuorService.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("Completed main...");
	}

}
