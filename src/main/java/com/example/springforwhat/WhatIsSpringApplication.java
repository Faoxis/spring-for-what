package com.example.springforwhat;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class WhatIsSpringApplication {

	public static void main(String[] args) {
//		TelegramService service1 = new TelegramService();
//		service1.sendMessage("1", "created by new");

//		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
//		System.out.println("Before get bean: " + TelegramService.isInitiated);
//		TelegramService service2 = beanFactory.getBean("telegramService", TelegramService.class);
//		System.out.println("After get bean: " + TelegramService.isInitiated);
//		service2.sendMessage("2", "created by BeanFactory");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Before get bean: " + TelegramService.isInitiated);
		TelegramService service3 = context.getBean("telegramService", TelegramService.class);
		System.out.println("After get bean: " + TelegramService.isInitiated);
		service3.sendMessage("3", "created by Application Context");

//		ApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);
//		TelegramService service4 = context2.getBean(TelegramService.class);
//		service4.sendMessage("4", "created by @Configuration and @Bean");

//		ApplicationContext context3 = new AnnotationConfigApplicationContext(Config2.class);
//		TelegramService service5 = context3.getBean(TelegramService.class);
//		service5.sendMessage("5", "created by @Configuration and @ComponentScan");

	}


}
