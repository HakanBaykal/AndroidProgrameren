package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.hakanmovieapp.adapters.StudioAdapter;
import com.example.hakanmovieapp.data.Actor;
import com.example.hakanmovieapp.data.Movie;
import com.example.hakanmovieapp.data.Studio;
import com.example.hakanmovieapp.views.MovieInputView;

import java.util.ArrayList;

public class AddMovieActivity extends AppCompatActivity {

    public static  final int RESULT_CODE = 1;
    public static final String RESULT_ARRAY_LIST_ACTORS = "actor_array_list";

    private Button buttonAddActorsToMovie;

    private Button buttonSaveNewMovie;

    private MovieInputView movieInputView;

    private RatingBar ratingBar;

    private ListView listViewStudios;

    private ArrayList<Actor> arrayListActors;

    private Studio studio = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        movieInputView = findViewById(R.id.movieInputView);
        buttonAddActorsToMovie = findViewById(R.id.buttonAddActorToMovie);
        buttonAddActorsToMovie.setText(R.string.value_menu_button_actor);
        buttonSaveNewMovie = findViewById(R.id.buttonMovieSave);
        buttonSaveNewMovie.setText(R.string.value_save_button);
        ratingBar = findViewById(R.id.ratingBarMovie);
        listViewStudios = findViewById(R.id.ListViewMovieAddStudio);

        StudioAdapter studioAdapter = new StudioAdapter(this,R.layout.activity_studio_list_item,TestData.instance.getStudios());
        listViewStudios.setAdapter(studioAdapter);

        listViewStudios.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                studio = (Studio) parent.getItemAtPosition(position);
            }
        });

        arrayListActors = new ArrayList<>();
    }

    //Moment dat AddMovieActorActivity stop ik hier alle acteurs die in dat scherm gekozen zijn bij de film
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            ArrayList<String> actorNames = data.getStringArrayListExtra(RESULT_ARRAY_LIST_ACTORS);

            for (String s : actorNames) {
                Actor a = TestData.instance.getActorByName(s);
                arrayListActors.add(a);
            }
        }
    }

    //hier open ik een activity naar de AddMovieActorActivity waar ik een lijst van namen van alle al geselecteerde acteurs mee geef
    //en ik start de activity voor result dus als die sluit gaat onActivityResult af
    public void addActorsToMovie(View view){
        ArrayList<String> actorNames = new ArrayList<>();
        for (Actor actor: arrayListActors){
            if (actor != null) {
                actorNames.add(actor.getName());
            }
        }
        Intent intent = new Intent(this,AddMovieActorActivity.class);
        intent.putExtra(RESULT_ARRAY_LIST_ACTORS,actorNames);
        startActivityForResult(intent,RESULT_CODE);
    }

    public void saveMovie(View view){
        String addMovieName = movieInputView.getAddMovieName();
        String addMovieGenre = movieInputView.getAddMovieGenre();
        String addMovieDirector = movieInputView. getAddMovieDirector();

        // hier worden alle verplichte velden gecheckt n geeft een Toast bericht als er iets vergeten is
        if (addMovieName.length() == 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_name_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (addMovieGenre.length() == 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_genre_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (addMovieDirector.length() == 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_director_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (studio == null){
            Toast toast = Toast.makeText(this,R.string.value_toast_studio_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Movie newMovie = new Movie(addMovieName, addMovieGenre, addMovieDirector, studio, (int)ratingBar.getRating());
            for (Actor a : arrayListActors){
                newMovie.addActor(a);
            }
            TestData.instance.addMovie(newMovie);
            setResult(MovieActivity.RESULT_MOVIE_KEY);
            finish();
        }
    }

}
