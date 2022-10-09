package com.example.springforwhat;


import com.example.springforwhat.di.DIExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringForWhatApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringForWhatApplication.class);

		var jokeSenderConstructor =
			ctx.getBean(DIExample.JokeToMessengerServiceConstructor.class);
		jokeSenderConstructor.sendJoke();

		var jokeSenderSetter =
			ctx.getBean(DIExample.JokeToMessengerServiceSetter.class);
		jokeSenderSetter.sendJoke();

		var jokeSenderProperty =
			ctx.getBean(DIExample.JokeMessengerServiceProperty.class);
		jokeSenderProperty.sendJoke();

	}

}
