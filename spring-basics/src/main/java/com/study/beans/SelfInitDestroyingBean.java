package com.study.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SelfInitDestroyingBean implements InitializingBean, DisposableBean {

	private HelloWorldBean hwb;

	public void afterPropertiesSet() throws Exception {
		System.out.println("Self Init - " + hwb);
	}

	public void destroy() throws Exception {
		System.out.println("Self destroying...");

	}
	
	public void sayHello() {
		hwb.sayHello();
	}

	public HelloWorldBean getHwb() {
		return hwb;
	}

	public void setHwb(HelloWorldBean hwb) {
		this.hwb = hwb;
	}
	
	

}
