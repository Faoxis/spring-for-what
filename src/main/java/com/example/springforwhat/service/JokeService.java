package com.example.springforwhat.service;

import com.example.springforwhat.client.ChuckNorrisJokeClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JokeService {
    private final ChuckNorrisJokeClient client;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String JOKE_JSON_FIELD = "value";

    public JokeService(ChuckNorrisJokeClient client) {
        this.client = client;
    }

    public String getRandomChuckNorrisJoke() {
        var jsonJoke = client.getRandomJoke();
        Map<String, Object> mapJoke = null;
        try {
            mapJoke = mapper.readValue(jsonJoke, new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return  (String) mapJoke.get(JOKE_JSON_FIELD);
    }

}
