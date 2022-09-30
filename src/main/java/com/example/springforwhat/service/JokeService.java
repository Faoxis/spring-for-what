package com.example.springforwhat.service;

import com.example.springforwhat.client.ChuckNorrisJokeClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JokeService {
    private final ChuckNorrisJokeClient client;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String JOKE_JSON_FIELD = "value";

    public JokeService(ChuckNorrisJokeClient client) {
        this.client = client;
    }

    public String getRandomChuckNorrisJoke() {
        return client.getRandomJoke();
    }

}
