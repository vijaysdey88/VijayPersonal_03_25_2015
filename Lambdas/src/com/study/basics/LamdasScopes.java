package com.study.basics;

import org.junit.Test;

public class LamdasScopes {
	int count = 0;

	private static int latestResult;

	@Test
	public void lamdasCanAccessNonFinalLocalVarsThatAreEffectivelyFinal() {
		int offset = 10;
		Adder<Integer> adderWithOffset = (i1, i2) ->  {
			// offset++; //Can't modify with lambda
			return i1 + i2 + offset;
		};

		//offset++; Can't modify var enclosed by lambda
		System.out.println(adderWithOffset.add(2, 3));
	}

	@Test
	public void canAccessAndMutateInstanceVars() {
		Adder<Integer> adder = (i1, i2) -> {
			count++;
			return i1 + i2;
		};
		
		adder.add(1, 4);
		System.out.println("Count : " + count);
		adder.add(1, 4);
		System.out.println("Count : " + count);
	}

	@Test
	public void canAccessAndMutateStaticFields() {
		Adder<Integer> adder = (i1, i2) -> {
			latestResult = i1 + i2;
			return latestResult;
		};

		adder.add(1, 4);
		System.out.println("Latest Result : " + LamdasScopes.latestResult);
		adder.add(5, 4);
		System.out.println("Latest Result : " + LamdasScopes.latestResult);
	}

	@Test
	public void cantAccessDefaultInterfaceMethods() {
		InterfaceWithDefault impl = () -> {
			String msg = "";
			// msg += sayHi(); can't access default interface methods
			msg += " blah blah";
			return msg;
		};

		System.out.println(impl.message());
	}
}
