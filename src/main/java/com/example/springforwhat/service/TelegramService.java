package com.example.springforwhat.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TelegramService implements
    InitializingBean,
    BeanFactoryAware,
    BeanClassLoaderAware,
    BeanNameAware,
    ApplicationContextAware {

    public TelegramService() {
        System.out.println("Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    public void sendMessage(String chatId, String text) throws InterruptedException {
        Thread.sleep(1_000);
        System.out.println("Sending message { " + text + " } with id " + chatId);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
        System.out.println("bean name: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }
}
