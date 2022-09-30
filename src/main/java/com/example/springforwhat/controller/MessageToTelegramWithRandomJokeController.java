package com.example.springforwhat.controller;

import com.example.springforwhat.service.SendingJokeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.io.IOException;

@RestController
public class MessageToTelegramWithRandomJokeController {

  private final SendingJokeService sendingJokeSevice;

  public MessageToTelegramWithRandomJokeController(SendingJokeService sendingJokeSevice) {
    this.sendingJokeSevice = sendingJokeSevice;
  }

  private final String CHAT_ID_PARAMETER = "chat-id";

  @GetMapping("/send-random-joke")
  public void doGet(@QueryParam("chat-id") String chatId) {
    sendingJokeSevice.sendRandomJokeToTelegram(chatId);
  }
}
