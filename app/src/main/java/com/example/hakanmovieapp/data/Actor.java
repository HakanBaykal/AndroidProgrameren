package com.example.hakanmovieapp.data;

import android.content.Context;

public class Actor {

    private String name;

    private int age;

    private String gender;

    public Actor(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean hasPicture(Context context){
        int pictureId = context.getResources().getIdentifier("actor_"+getName().toLowerCase().replaceAll("\\s+",""), "drawable", context.getPackageName());

        return pictureId != 0;
    }
}
