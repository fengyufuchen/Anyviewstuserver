package com.anyview.server.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anyview.server.handler.SubscribeServer;

public class SubscribeServerStart {
	
	/**
	 * spring容器: ApplicationContext
	 * 单例模式
	 */
	public static ApplicationContext spctx = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static void main(String[] args) throws Exception {
		int port = 8888;
		if(args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				//
			}
		}
		System.out.println("Server Starts...");
		
		//DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(isr);
		//ctx.getAutowireCapableBeanFactory();
		
		for(String beans : spctx.getBeanDefinitionNames())
			System.out.println(beans);
		new SubscribeServer().bind(port);
	}
}
