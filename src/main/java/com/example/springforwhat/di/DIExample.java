package com.example.springforwhat.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Сейчас важно понять не как он это делает (об это еще поговорим),
 * а что он умеет так делать
 *
 */
@Component
public class DIExample {

    public interface SenderService {
        void sendMessage(String chatId, String text);
    }

    @Component
    public static class TelegramService implements SenderService {
        public void sendMessage(String chatId, String text) {
            System.out.println("Sending message to telegram chat " + chatId + " with text " + text);
        }
    }

    @Component
    public static class JokeToMessengerServiceConstructor {
        private final SenderService senderService;
        public JokeToMessengerServiceConstructor(SenderService senderService) {
            this.senderService = senderService;
        }
        public void sendJoke() {
            senderService.sendMessage("42", "Hello from DI by constructor!");
        }
    }

    @Component
    public static class JokeToMessengerServiceSetter {
        @Autowired
        public void setSenderService(SenderService senderService) {
            this.senderService = senderService;
        }

        private SenderService senderService;
        public void sendJoke() {
            senderService.sendMessage("42", "Hello from DI by setter");
        }
    }

    @Component
    public static class JokeMessengerServiceProperty {
        @Autowired
        private SenderService senderService;
        public void sendJoke() {
            senderService.sendMessage("42", "Hello from DI by property");
        }
    }
}
