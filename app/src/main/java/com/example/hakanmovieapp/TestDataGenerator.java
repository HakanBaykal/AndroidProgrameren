package com.example.hakanmovieapp;

import com.example.hakanmovieapp.data.Actor;
import com.example.hakanmovieapp.data.Movie;
import com.example.hakanmovieapp.data.MovieQuote;
import com.example.hakanmovieapp.data.Studio;

import java.util.ArrayList;
import java.util.Random;

public class TestDataGenerator {

    private ArrayList<Movie> testMovies;
    private ArrayList<Actor> testActors;
    private ArrayList<Studio> testStudios;
    private ArrayList<MovieQuote> testMovieQuotes;

    public void generateTestData(){
        Actor testActor1 = new Actor("Samuel L Jackson",70,"Male");
        Actor testActor2 = new Actor("John Travolta",65, "Male");
        Actor testActor3 = new Actor("Uma Thurman",48, "Female");
        Actor testActor4 = new Actor("Steve Buscemi", 61, "Male");
        Actor testActor5 = new Actor("Jamie Foxx", 51, "Male");
        Actor testActor6 = new Actor("Jason Statham", 51, "Male");

        ArrayList<Actor> testActors = new ArrayList<>();
        testActors.add(testActor1);
        testActors.add(testActor2);
        testActors.add(testActor3);
        testActors.add(testActor4);
        testActors.add(testActor5);
        testActors.add(testActor6);

        Studio testStudio1 = new Studio("Miramax", "Bob Weinstein","beIN Media Group");

        ArrayList<Studio> testStudios = new ArrayList<>();
        testStudios.add(testStudio1);

        Movie testmovie1 = new Movie("Django Unchained","Action","Quentin Tarantino",testStudio1,1);
        Movie testmovie2 = new Movie("Resevior Dogs","Action","Quentin Tarantino",testStudio1,2);
        Movie testmovie3 = new Movie("Pulp Fiction","Action","Quentin Tarantino",testStudio1,3);
        Movie testmovie4 = new Movie("Kill Bill","Action","Quentin Tarantino",testStudio1,4);
        Movie testmovie5 = new Movie("Kill Bill  vol II","Action","Quentin Tarantino",testStudio1,5);
        Movie testmovie6 = new Movie("Hateful Eight","Action","Quentin Tarantino",testStudio1,4);

        ArrayList<Movie> testMovies = new ArrayList<>();
        testMovies.add(testmovie1);
        testMovies.add(testmovie2);
        testMovies.add(testmovie3);
        testMovies.add(testmovie4);
        testMovies.add(testmovie5);
        testMovies.add(testmovie6);

        for (Movie m : testMovies){
            for (Actor a : testActors){
                m.addActor(a);
            }
        }

        this.testMovies = testMovies;
        this.testActors = testActors;
        this.testStudios = testStudios;

        MovieQuote testQuote1 = new MovieQuote("You believe in Jesus now, huh bitch? Well good. 'Cause you 'bout to meet him.","THE HATEFUL EIGHT");
        MovieQuote testQuote2 = new MovieQuote("I like the way you die, boy!","DJANGO UNCHAINED");
        MovieQuote testQuote3 = new MovieQuote("Gentleman, you had my curiosity, now you have my attention.","DJANGO UNCHAINED");
        MovieQuote testQuote4 = new MovieQuote("Once we're in enemy territory, we're gonna be doing one thing and one thing only—killing Nazis.","INGLORIOUS BASTERDS");
        MovieQuote testQuote5 = new MovieQuote("We ain't in the prisoner-takin' business, we in the nazi-killin' business, and business is boomin.","INGLORIOUS BASTERDS");
        MovieQuote testQuote6 = new MovieQuote("We got a German here who wants to die for his country. Oblige him.","INGLORIOUS BASTERDS");
        MovieQuote testQuote7 = new MovieQuote("A good cop will never let you know he knows you're full of shit.","JACKIE BROWN");
        MovieQuote testQuote8 = new MovieQuote("Say what again… I dare you… I double dare you, motherfucker!","PULP FICTION");
        MovieQuote testQuote9 = new MovieQuote("Does Marcellus Wallace look like bitch.","PULP FICTION");
        MovieQuote testQuote10 = new MovieQuote("English, motherfucker, do you speak it?","PULP FICTION");
        MovieQuote testQuote11 = new MovieQuote("You know what they call a Quarter Pounder with Cheese in Paris? \n They call it Royale with Cheese.","PULP FICTION");
        MovieQuote testQuote12 = new MovieQuote("If you shoot me in a dream you better wake up and apologize","RESERVOIR DOGS");

        testMovieQuotes = new ArrayList<>();
        testMovieQuotes.add(testQuote1);
        testMovieQuotes.add(testQuote2);
        testMovieQuotes.add(testQuote3);
        testMovieQuotes.add(testQuote4);
        testMovieQuotes.add(testQuote5);
        testMovieQuotes.add(testQuote6);
        testMovieQuotes.add(testQuote7);
        testMovieQuotes.add(testQuote8);
        testMovieQuotes.add(testQuote9);
        testMovieQuotes.add(testQuote10);
        testMovieQuotes.add(testQuote11);
        testMovieQuotes.add(testQuote12);
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

    public MovieQuote getRandomTestMovieQuote() {
        Random r = new Random();
        int i = (r.nextInt(testMovieQuotes.size()-1));

        return testMovieQuotes.get(i);
    }

    public Movie getMovieByName(String name){
        for (Movie m : testMovies){
            if (m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    public Actor getActorByName(String name){
        for (Actor a : testActors){
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

    public Studio getStudioByName(String name){
        for (Studio s : testStudios){
            if (s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

    public void addMovie(Movie movie){
        testMovies.add(movie);
    }

    public void removeMovie(Movie movie){
        testMovies.remove(movie);
    }

    public void addActor(Actor actor){
        testActors.add(actor);
    }

    public void removeActor(Actor actor){
        testActors.remove(actor);
    }
}
