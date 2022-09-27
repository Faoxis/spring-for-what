package com.example.springforwhat.service;

import com.example.springforwhat.client.TelegramBotClient;

public class TelegramService {

    private final TelegramBotClient client;

    public TelegramService(TelegramBotClient client) {
        this.client = client;
    }

    public void sendMessage(String chatId, String text) {
        client.sendMessage(chatId, text);
    }

}
