package com.example.hakanmovieapp.data;

import java.util.ArrayList;

public class Movie {
    private String name;

    private String genre;

    private String director;

    private ArrayList<Actor> actors;

    private Studio studio;

    public Movie(String name, String genre, String director,ArrayList<Actor> actors, Studio studio) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.studio = studio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
