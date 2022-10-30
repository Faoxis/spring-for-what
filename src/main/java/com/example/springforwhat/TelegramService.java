package com.example.springforwhat;

import org.springframework.stereotype.Component;

//@Component
public class TelegramService {

    public static boolean isInitiated = false;

    public TelegramService() {
        isInitiated = true;
    }

    public void sendMessage(String chatId, String text) {
        System.out.println("Sending message { " + text + " } with id " + chatId);
    }
}
