package com.example.hakanmovieapp;

import com.example.hakanmovieapp.data.Actor;
import com.example.hakanmovieapp.data.Movie;
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
}
