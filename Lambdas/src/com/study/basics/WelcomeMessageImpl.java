package com.study.basics;

import org.junit.Test;

public class WelcomeMessageImpl implements InterfaceWithDefault {

	@Override
	public String message() {
		return sayHi() + " world!!!";
	}

	@Test
	public void testBehaviorWithDefaultImpl() {
		System.out.println(new WelcomeMessageImpl().message());
	}

	@Test
	public void lamdaExpressionCantAccessDefaultInterfaceMethods() {
		InterfaceWithDefault impl = () -> {
			String msg = "";
			// msg += sayHi(); can't access defaul interface methods
			msg += " blah blah";
			return msg;
		};

		System.out.println(impl.message());
	}

}
