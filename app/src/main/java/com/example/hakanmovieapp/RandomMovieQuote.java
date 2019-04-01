package com.example.hakanmovieapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hakanmovieapp.data.MovieQuote;

import java.util.Timer;

public class RandomMovieQuote extends AppCompatActivity {

    TextView textViewMovie;

    TextView textViewQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_movie_quote);

        textViewMovie = findViewById(R.id.textViewMovie);
        textViewQuote = findViewById(R.id.textViewQuote);
        MovieQuote movieQuote = TestData.instance.getRandomMovieQuote();

        textViewMovie.setText(movieQuote.getMovie());
        textViewQuote.setText(movieQuote.getQuote());

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 5000);
    }
}
