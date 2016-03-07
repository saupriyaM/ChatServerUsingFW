package com.jf.chatserver.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ApplicationContextUtils implements ApplicationContextAware {

	private static ApplicationContext appContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		appContext = applicationContext;
		
	}
	
	public static ApplicationContext getApplicationContext(){
		return appContext;
	}
}
