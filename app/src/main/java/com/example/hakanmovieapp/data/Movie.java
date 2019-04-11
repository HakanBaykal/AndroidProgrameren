package com.example.hakanmovieapp.data;

import android.content.Context;

import java.util.ArrayList;

public class Movie {
    private String name;

    private String genre;

    private String director;

    private ArrayList<Actor> actors;

    private Studio studio;

    private int rating;

    public Movie(String name, String genre, String director, Studio studio,int rating) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.actors = new ArrayList<>();
        this.studio = studio;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean hasPicture(Context context){
        int pictureId = context.getResources().getIdentifier("movie_"+getName().toLowerCase().replaceAll("\\s+",""), "drawable", context.getPackageName());

        return pictureId != 0;
    }

    public void addActor(Actor a){
        actors.add(a);
    }


}
