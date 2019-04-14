package com.example.hakanmovieapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.hakanmovieapp.adapters.MovieAdapter;
import com.example.hakanmovieapp.data.Movie;

public class MovieActivity extends AppCompatActivity {

    public static final String ID_KEY = "id_key";
    public static final int RESULT_MOVIE_KEY = 123872;

    private ListView movieListView;
    private MovieAdapter movieListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        movieListView = findViewById(R.id.movieListView);
        movieListViewAdapter = new MovieAdapter(this,R.layout.activity_movie__list__item,TestData.instance.getMovies());
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

        movieListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TestData.instance.removeMovie(movieListViewAdapter.getItem(position));
                movieListViewAdapter.notifyDataSetChanged();
                return false;
            }
        });

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieActivity.this, AddMovieActivity.class);
                startActivityForResult(intent, RESULT_MOVIE_KEY);
                movieListViewAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_MOVIE_KEY) {
            movieListViewAdapter.notifyDataSetChanged();
        }
    }

}
