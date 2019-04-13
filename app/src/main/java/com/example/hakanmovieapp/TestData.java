package com.example.hakanmovieapp;

import com.example.hakanmovieapp.data.Actor;
import com.example.hakanmovieapp.data.Movie;
import com.example.hakanmovieapp.data.MovieQuote;
import com.example.hakanmovieapp.data.Studio;

import java.util.ArrayList;

public class TestData {

    public static final TestData instance = new TestData();


    private TestDataGenerator testDataGenerator;

    private TestData() {
        this.testDataGenerator = new TestDataGenerator();
        testDataGenerator.generateTestData();
    }

    public ArrayList<Movie> getMovies(){
        return testDataGenerator.getTestMovies();
    }

    public ArrayList<Actor> getActors(){
        return testDataGenerator.getTestActors();
    }

    public ArrayList<Studio> getStudios(){
        return testDataGenerator.getTestStudios();
    }

    public MovieQuote getRandomMovieQuote(){
        return testDataGenerator.getRandomTestMovieQuote();
    }

    public Movie getMovieByName(String name){
        return testDataGenerator.getMovieByName(name);
    }

    public Actor getActorByName(String name){
        return testDataGenerator.getActorByName(name);
    }

    public Studio getStudioByName(String name){
        return testDataGenerator.getStudioByName(name);
    }

    public void addMovie(Movie movie){
        testDataGenerator.addMovie(movie);
    }

    public void removeMovie(Movie movie){
        testDataGenerator.removeMovie(movie);
    }

    public void addActor(Actor actor){
        testDataGenerator.addActor(actor);
    }

    public void removeActor(Actor actor){
        testDataGenerator.removeActor(actor);
    }

    public void addStudio(Studio studio){
        testDataGenerator.addStudio(studio);
    }

    public void removeStudio(Studio studio){ testDataGenerator.removeStudio(studio);}
}
