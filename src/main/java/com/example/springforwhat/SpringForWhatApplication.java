package com.example.springforwhat;


import com.example.springforwhat.client.ChuckNorrisJokeClient;
import com.example.springforwhat.client.TelegramBotClient;
import com.example.springforwhat.controller.MessageToTelegramWithRandomJokeController;
import com.example.springforwhat.service.JokeService;
import com.example.springforwhat.service.SendingJokeService;
import com.example.springforwhat.service.TelegramService;
import jakarta.servlet.http.HttpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class SpringForWhatApplication {

	public static void main(String[] args) throws Exception {
		// joke
		ChuckNorrisJokeClient jokeClient = new ChuckNorrisJokeClient();
		JokeService jokeService = new JokeService(jokeClient);

		// telegram
		TelegramBotClient botClient = new TelegramBotClient();
		TelegramService botService = new TelegramService(botClient);

		// general logic
		SendingJokeService service = new SendingJokeService(jokeService, botService);

		// controller
		MessageToTelegramWithRandomJokeController sendMessageToTelegramController =
			new MessageToTelegramWithRandomJokeController(service);

		configureAndStartJettyServer(8082, sendMessageToTelegramController, "/send-random-joke");
	}

	private static void configureAndStartJettyServer(int port, HttpServlet servlet, String path) throws Exception {
		Server server = new Server(port);

		var handler = new ServletHandler();
		server.setHandler(handler);

		ServletHolder servletHolder = new ServletHolder();
		servletHolder.setServlet(servlet);

		handler.addServletWithMapping(servletHolder, path);

		server.start();
		server.join();
	}

}
