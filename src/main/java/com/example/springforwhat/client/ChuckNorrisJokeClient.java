package com.example.springforwhat.client;

import org.springframework.asm.TypeReference;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Component
public class ChuckNorrisJokeClient {

    private final RestTemplate template = new RestTemplate();
    private final static URI RANDOM_JOKE_URI = URI.create("https://api.chucknorris.io/jokes/random");

    public String getRandomJoke() {
        return template.getForEntity(RANDOM_JOKE_URI, String.class).getBody();
    }

}
