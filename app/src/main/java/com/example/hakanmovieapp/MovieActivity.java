package com.example.hakanmovieapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.hakanmovieapp.adapters.MovieAdapter;
import com.example.hakanmovieapp.data.Movie;

public class MovieActivity extends AppCompatActivity {

    public static final String ID_KEY = "id_key";

    ListView movieListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        movieListView = findViewById(R.id.movieListView);
        MovieAdapter movieListViewAdapter = new MovieAdapter(this,R.layout.activity_movie__list__item,TestData.instance.getMovies());
        movieListView.setAdapter(movieListViewAdapter);

        movieListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie m = (Movie) parent.getItemAtPosition(position);

                Intent intent = new Intent(MovieActivity.this, MovieDetailActivity.class);
                intent.putExtra(ID_KEY,m.getName());

                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
