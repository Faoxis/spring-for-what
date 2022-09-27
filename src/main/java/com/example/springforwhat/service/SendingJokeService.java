package com.example.springforwhat.service;

public class SendingJokeService {
    private final JokeService jokeService;
    private final TelegramService telegramService;

    public SendingJokeService(JokeService jokeService, TelegramService telegramService) {
        this.jokeService = jokeService;
        this.telegramService = telegramService;
    }

    public void sendRandomJokeToTelegram(String chatId) {
        String joke = jokeService.getRandomChuckNorrisJoke();
        telegramService.sendMessage(chatId, joke);
    }
}
