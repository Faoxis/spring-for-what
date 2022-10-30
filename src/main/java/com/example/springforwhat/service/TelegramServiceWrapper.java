package com.example.springforwhat.service;

public class TelegramServiceWrapper extends TelegramService {

    private final TelegramService telegramService;


    public TelegramServiceWrapper(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public void sendMessage(String chatId, String text) throws InterruptedException {
        long start = System.currentTimeMillis();
        telegramService.sendMessage(chatId, text);
        long end = System.currentTimeMillis();
        System.out.println("This method takes " + (end - start) + " ms");
    }
}
