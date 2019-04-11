package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hakanmovieapp.adapters.ActorAdapter;
import com.example.hakanmovieapp.data.Actor;
import com.example.hakanmovieapp.data.Movie;
import com.example.hakanmovieapp.views.RatingView;

public class MovieDetailActivity extends AppCompatActivity {
    ImageView imageViewDetailMovie;

    TextView textViewDetailMovieName;
    TextView textViewDetailMovieGenre;
    TextView textViewDetailMovieStudioName;

    ListView listViewDetailMovieActors;

    RatingView ratingView;

    Movie detailMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        imageViewDetailMovie = findViewById(R.id.imageViewDetailMovie);
        textViewDetailMovieName = findViewById(R.id.textViewDetailMovieName);
        textViewDetailMovieGenre = findViewById(R.id.textViewDetailMovieGenre);
        textViewDetailMovieStudioName = findViewById(R.id.textViewDetailMovieStudioName);
        listViewDetailMovieActors =findViewById(R.id.ListviewDetailMovieActors);
        ratingView = findViewById(R.id.RatingView);


        detailMovie =  TestData.instance.getMovieByName(getIntent().getStringExtra(MovieActivity.ID_KEY));

        ActorAdapter actorAdapter = new ActorAdapter(this,R.layout.activity_actor__list__item,detailMovie.getActors());

        if (imageViewDetailMovie != null) {
            if (detailMovie.hasPicture(this)) {
                imageViewDetailMovie.setImageResource(this.getResources().getIdentifier("movie_" + detailMovie.getName().toLowerCase().replaceAll("\\s+", ""), "drawable", this.getPackageName()));
            }
        }

        if (textViewDetailMovieName != null){
            textViewDetailMovieName.setText(detailMovie.getName());
        }

        if (textViewDetailMovieGenre !=  null){
            textViewDetailMovieGenre.setText(detailMovie.getGenre());
        }

        if (textViewDetailMovieStudioName != null){
            textViewDetailMovieStudioName.setText(detailMovie.getStudio().getName());
        }

        if (listViewDetailMovieActors != null){
            listViewDetailMovieActors.setAdapter(actorAdapter);

            listViewDetailMovieActors.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Actor a = (Actor) parent.getItemAtPosition(position);

                    Intent intent = new Intent(MovieDetailActivity.this, ActorDetailActivity.class);
                    intent.putExtra(ActorActivity.ACTOR_ID_KEY, a.getName());

                    startActivity(intent);
                }
            });
        }

        if (ratingView != null){
            ratingView.setModel(detailMovie);
        }
    }

    public void openUpdateMovieActivity(View view){
        Intent intent = new Intent(this,UpdateMovieActivity.class);
        intent.putExtra(MovieActivity.ID_KEY, detailMovie.getName());

        startActivity(intent);
        finish();
    }


}
