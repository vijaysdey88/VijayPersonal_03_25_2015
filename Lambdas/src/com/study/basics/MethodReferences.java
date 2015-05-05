package com.study.basics;

import org.junit.Test;

public class MethodReferences {

	public static int addInt(int x, int y) {
		return x + y;
	}

	private static class Util {
		public String addStr(String x, String y) {
			return x + y;
		}
	}

	@Test
	public void methodReferenceForStaticMethods() {
		Adder<Integer> intAdder = MethodReferences::addInt;
		System.out.println(intAdder.add(2, 5));
	}

	@Test
	public void useMethodReferenceOnAnInstance() {
		Util util = new Util();
		Adder<String> strAdder = util::addStr;
		System.out.println(strAdder.add("a", "b"));

	}

}
