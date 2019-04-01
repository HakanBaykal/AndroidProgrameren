package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hakanmovieapp.data.MovieQuote;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMovieActivity(View view){
        Intent movieIntent = new Intent(this, MovieActivity.class);
        startActivity(movieIntent);
    }

    public void goToActorActivity(View view){
        Intent actorIntent = new Intent(this, ActorActivity.class);
        startActivity(actorIntent);
    }

    public void goToStudioActivity(View view){
        Intent studioIntent = new Intent(this, StudioActivity.class);
        startActivity(studioIntent);
    }

    public void showMoviequote(View view){
        Intent quoteIntent = new Intent(this, RandomMovieQuote.class);
        startActivity(quoteIntent);
    }
}
