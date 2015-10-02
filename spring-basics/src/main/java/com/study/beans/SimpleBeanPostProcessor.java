package com.study.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class SimpleBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SimpleBeanPostProcessor postProcessBEFOREInitialization - " + bean + " " + beanName);
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("SimpleBeanPostProcessor postProcessAFTERInitialization - " + bean + " " + beanName);
		return bean;
	}

}
