package com.example.springforwhat.controller;

import com.example.springforwhat.service.SendingJokeService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MessageToTelegramWithRandomJokeController extends HttpServlet {

  private final SendingJokeService sendingJokeSevice;

  public MessageToTelegramWithRandomJokeController(SendingJokeService sendingJokeSevice) {
    this.sendingJokeSevice = sendingJokeSevice;
  }

  private final String CHAT_ID_PARAMETER = "chat-id";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    var chatId = request.getParameter(CHAT_ID_PARAMETER);
    sendingJokeSevice.sendRandomJokeToTelegram(chatId);

    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_OK);
    response.getWriter().println("{ \"status\": \"ok\" }");
  }
}
