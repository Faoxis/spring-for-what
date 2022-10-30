package com.example.springforwhat.config;

import com.example.springforwhat.service.TelegramService;
import com.example.springforwhat.service.TelegramServiceWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TelegramService) {
            System.out.println("postProcessBeforeInitialization");
//            TelegramService service = new TelegramServiceWrapper((TelegramService) bean);
//            return BeanPostProcessor.super.postProcessBeforeInitialization(service, beanName);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TelegramService) {
            System.out.println("postProcessAfterInitialization");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
