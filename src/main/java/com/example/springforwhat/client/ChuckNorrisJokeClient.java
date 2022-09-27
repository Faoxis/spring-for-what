package com.example.springforwhat.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChuckNorrisJokeClient {

    private final HttpClient client = HttpClient.newBuilder().build();
    private final static URI RANDOM_JOKE_URI = URI.create("https://api.chucknorris.io/jokes/random");

    public String getRandomJoke() {
        HttpRequest request = HttpRequest.newBuilder()
                                  .GET()
                                  .uri(RANDOM_JOKE_URI)
                                  .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
