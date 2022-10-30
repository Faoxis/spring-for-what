package com.example.springforwhat;


import com.example.springforwhat.service.TelegramService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WhatIsSpringApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx =
			SpringApplication.run(WhatIsSpringApplication.class);
		TelegramService service = ctx.getBean(TelegramService.class);
		service.sendMessage("42", "Hey");
	}


}
