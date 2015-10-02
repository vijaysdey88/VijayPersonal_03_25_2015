package com.study.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class ExecutorBean {
	
	private ServiceBean serviceBean;
	
	public void execute() {
		System.out.println("ExecutorBean - execute() + " + this);
	}

	@Override
	public String toString() {
		return "ExecutorBean [service=" + serviceBean + "]";
	}

	public ServiceBean getServiceBean() {
		return serviceBean;
	}

	@Required
	public void setServiceBean(ServiceBean serviceBean) {
		this.serviceBean = serviceBean;
	}
	
}
