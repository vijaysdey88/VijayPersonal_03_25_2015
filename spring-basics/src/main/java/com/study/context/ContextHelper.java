package com.study.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public final class ContextHelper {

	private final AbstractApplicationContext ctx;
	
	private ContextHelper() {
		ctx = new ClassPathXmlApplicationContext("appContext.xml");
		ctx.registerShutdownHook();
	}

	public static ContextHelper INSTANCE  = new ContextHelper();
	
	public ApplicationContext getConext() {
		return ctx;
	}
	
	
	public <T> T getBean(Class<T> beanType) {
		return ctx.getBean(beanType);
	}
}
