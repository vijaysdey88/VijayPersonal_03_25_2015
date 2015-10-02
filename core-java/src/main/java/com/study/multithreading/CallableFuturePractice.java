package com.study.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuturePractice {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
	
		Future<Void> f = es.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				ThreadHelper.sleep(500);
				return null;
			}
		});
		
		try {
			System.out.println("Result " + f.get());
		} catch (InterruptedException | ExecutionException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();
	}
}
