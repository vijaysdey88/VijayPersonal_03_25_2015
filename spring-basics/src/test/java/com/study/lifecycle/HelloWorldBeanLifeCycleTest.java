package com.study.lifecycle;

import org.junit.Test;

import com.study.beans.HelloWorldBean;
import com.study.beans.SelfInitDestroyingBean;
import com.study.context.ContextHelper;

public class HelloWorldBeanLifeCycleTest {

	private static final ContextHelper HELPER = ContextHelper.INSTANCE;

	@Test
	public void testInitDestroyMethods() {
		HelloWorldBean hw = HELPER.getBean(HelloWorldBean.class);
		hw.sayHello();
	}
	
	
	@Test
	public void testSelfInitDestroyingBean() {
		SelfInitDestroyingBean swb = HELPER.getBean(SelfInitDestroyingBean.class);
		swb.sayHello();
	}
	
}
