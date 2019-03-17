package com.example.hakanmovieapp;

import com.example.hakanmovieapp.data.Actor;
import com.example.hakanmovieapp.data.Movie;
import com.example.hakanmovieapp.data.Studio;

import java.util.ArrayList;

public class TestDataGenerator {

    private ArrayList<Movie> testMovies;
    private ArrayList<Actor> testActors;
    private ArrayList<Studio> testStudios;

    public void generateTestData(){
        Actor testActor1 = new Actor("Samuel L Jackson",70,"male");
        Actor testActor2 = new Actor("John Travolta",65, "male");
        Actor testActor3 = new Actor("Uma Thurman",48, "female");
        Actor testActor4 = new Actor("Steve Buscemi", 61, "male");
        Actor testActor5 = new Actor("Jamie Foxx", 51, "Male");

        ArrayList<Actor> testActors = new ArrayList<>();
        testActors.add(testActor1);
        testActors.add(testActor2);
        testActors.add(testActor3);
        testActors.add(testActor4);
        testActors.add(testActor5);

        Studio testStudio1 = new Studio("Miramax", "Bob Weinstein","beIN Media Group");

        ArrayList<Studio> testStudios = new ArrayList<>();
        testStudios.add(testStudio1);

        Movie testmovie1 = new Movie("Django Unchained","Action","Quentin Tarantino",testActors,testStudio1);
        Movie testmovie2 = new Movie("Resevior Dogs","Action","Quentin Tarantino",testActors,testStudio1);
        Movie testmovie3 = new Movie("Pulp Fiction","Action","Quentin Tarantino",testActors,testStudio1);
        Movie testmovie4 = new Movie("Kill Bill","Action","Quentin Tarantino",testActors,testStudio1);
        Movie testmovie5 = new Movie("Kill Bill  vol II","Action","Quentin Tarantino",testActors,testStudio1);
        Movie testmovie6 = new Movie("Hatefull Eight","Action","Quentin Tarantino",testActors,testStudio1);

        ArrayList<Movie> testMovies = new ArrayList<>();
        testMovies.add(testmovie1);
        testMovies.add(testmovie2);
        testMovies.add(testmovie3);
        testMovies.add(testmovie4);
        testMovies.add(testmovie5);
        testMovies.add(testmovie6);

        this.testMovies = testMovies;
        this.testActors = testActors;
        this.testStudios = testStudios;
    }

    public ArrayList<Movie> getTestMovies() {
        return testMovies;
    }

    public ArrayList<Actor> getTestActors() {
        return testActors;
    }

    public ArrayList<Studio> getTestStudios() {
        return testStudios;
    }
}
