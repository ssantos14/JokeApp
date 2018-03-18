package com.example.android.javajokegenerator;

import java.util.Random;

public class JokeGenerator {
    public String getJoke(){
        int numberOfJokes = Jokes.length;
        Random rand = new Random();
        int jokeIndex = rand.nextInt(numberOfJokes);
        return Jokes[jokeIndex];
    }

    private String[] Jokes = {
            "Which of King Arthur's knights built the round table? Sir Cumfrence",
            "Why do cows have hooves instead of feet? Because they lack toes",
            "What happens to frogs when they park illegally? They get toad",
            "Why did the Norwegian Navy put barcodes on their ships? So that when they dock they can Scandinavian"
    };
}
