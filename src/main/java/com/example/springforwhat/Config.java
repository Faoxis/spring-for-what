package com.example.springforwhat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TelegramService telegramService() {
        return new TelegramService();
    }

}
