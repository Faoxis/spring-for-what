package com.example.springforwhat.client;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class TelegramBotClient {
    private final static String BOT_LOGIN = "MySuperMegaAmazingBot";
    private final static String BOT_TOKEN = "1926990429:AAHIKeXS5YKCDVw4wEDC9Zv4obOmyUWoiD4";
    private final MyBot bot = new MyBot(BOT_LOGIN, BOT_TOKEN);

    public TelegramBotClient() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String chatId, String text) {
        bot.sendMessage(chatId, text);
    }


    private static class MyBot extends TelegramLongPollingBot {
        private final String username;
        private final String token;

        private MyBot(String username, String token) {
            this.username = username;
            this.token = token;
        }

        public void sendMessage(String chatId, String text) {
            try {
                execute(new SendMessage(chatId, text));
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onUpdateReceived(Update update) {
            if (update.hasMessage() && update.getMessage().hasText()) {
                SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText(update.getMessage().getText());

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String getBotUsername() {
            return username;
        }

        @Override
        public String getBotToken() {
            return token;
        }
    }
}
