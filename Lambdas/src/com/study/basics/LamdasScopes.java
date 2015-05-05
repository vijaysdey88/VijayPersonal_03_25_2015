package com.study.basics;

import org.junit.Test;

public class LamdasScopes {
	int count = 0;

	private static int latestResult;

	@Test
	public void lamdasCanAccessNonFinalLocalVarsThatAreEffectivelyFinal() {
		Adder<Integer> adderWithOffset = create(10);

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
			// msg += sayHi(); can't access defaul interface methods
			msg += " blah blah";
			return msg;
		};

		System.out.println(impl.message());
	}

	private Adder<Integer> create(int offset) {

		Adder<Integer> adder = (i1, i2) -> {
			// offset++; Can't modify with lambda
			return offset + i1 + i2;
		};

		// Can't modify var enclosed by lambda
		// i++;
		return adder;
	}

}
