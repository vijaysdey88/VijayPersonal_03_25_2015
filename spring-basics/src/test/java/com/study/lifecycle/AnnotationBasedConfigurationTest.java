package com.study.lifecycle;

import org.junit.Test;

import com.study.beans.ExecutorBean;
import com.study.context.ContextHelper;

public class AnnotationBasedConfigurationTest {
	
	private static final ContextHelper HELPER = ContextHelper.INSTANCE;


	@Test
	public void shouldThrowExceptionWhenRequiredPropertyNotConfigured() {
		ExecutorBean eb = HELPER.getBean(ExecutorBean.class);
		eb.execute();
	}
}
