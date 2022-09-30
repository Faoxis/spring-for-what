package com.example.springforwhat.service;

import com.example.springforwhat.client.TelegramBotClient;
import org.springframework.stereotype.Service;

@Service
public class TelegramService {

    private final TelegramBotClient client;

    public TelegramService(TelegramBotClient client) {
        this.client = client;
    }

    public void sendMessage(String chatId, String text) {
        client.sendMessage(chatId, text);
    }

}
