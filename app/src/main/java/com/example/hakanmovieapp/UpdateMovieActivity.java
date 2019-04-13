package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class UpdateMovieActivity extends AppCompatActivity {


    private MovieInputView movieInputView;

    private RatingBar ratingBarUpdate;

    private ListView listViewUpdateStudios;

    private Button buttonUpdateMovieActors;

    private Button buttonUpdateMovieSave;

    private ArrayList<Actor> arrayListActors;

    private Studio studio = null;

    private Movie movieToUpdate;

    private StudioAdapter studioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_movie);

        movieInputView = findViewById(R.id.MovieInputViewUpdate);

        ratingBarUpdate = findViewById(R.id.ratingBarUpdateMovie);

        listViewUpdateStudios = findViewById(R.id.ListViewMovieUpdateStudio);

        buttonUpdateMovieActors = findViewById(R.id.buttonUpdateActorOfMovie);
        buttonUpdateMovieActors.setText(R.string.value_menu_button_actor);
        buttonUpdateMovieSave = findViewById(R.id.buttonUpdateMovieSave);
        buttonUpdateMovieSave.setText(R.string.value_save_button);

        movieToUpdate = TestData.instance.getMovieByName(this.getIntent().getStringExtra(MovieActivity.ID_KEY));

        movieInputView.setAddMovieName(movieToUpdate.getName());
        movieInputView.setAddMovieGenre(movieToUpdate.getGenre());
        movieInputView.setAddMovieDirector(movieToUpdate.getDirector());

        ratingBarUpdate.setRating(movieToUpdate.getRating());

        studioAdapter = new StudioAdapter(this, R.layout.activity_studio_list_item,TestData.instance.getStudios());
        listViewUpdateStudios.setAdapter(studioAdapter);

        studio = movieToUpdate.getStudio();
        int studioPositionInList = getPositionOfSelectedStudio(studio.getName());

        if (studioPositionInList >= 0){
            listViewUpdateStudios.setSelection(studioPositionInList);
        }

        arrayListActors = movieToUpdate.getActors();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            ArrayList<String> actorNames = data.getStringArrayListExtra(AddMovieActivity.RESULT_ARRAY_LIST_ACTORS);
            arrayListActors = new ArrayList<>();
            for (String s : actorNames) {
                Actor a = TestData.instance.getActorByName(s);
                arrayListActors.add(a);
            }
        }
    }

    public void UpdateActorsOfMovie(View view){
        ArrayList<String> actorNames = new ArrayList<>();
        for (Actor actor: arrayListActors){
            if (actor != null) {
                actorNames.add(actor.getName());
            }
        }
        Intent intent = new Intent(this,AddMovieActorActivity.class);
        intent.putExtra(AddMovieActivity.RESULT_ARRAY_LIST_ACTORS,actorNames);
        startActivityForResult(intent, AddMovieActivity.RESULT_CODE);
    }

    public int getPositionOfSelectedStudio(String studioName){
        int listviewSize = listViewUpdateStudios.getCount();

        for (int i = 0; i < listviewSize; i++){
            Studio listItemStudioToCheck =(Studio) listViewUpdateStudios.getItemAtPosition(i);
            if (listItemStudioToCheck != null) {
                if (listItemStudioToCheck.getName().equals(studioName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void saveUpdatedMovie(View view){
        String updatedMovieName = movieInputView.getAddMovieName();
        String updatedMovieGenre = movieInputView.getAddMovieGenre();
        String updateMovieDirector = movieInputView.getAddMovieDirector();

        float updatedMovieRating = ratingBarUpdate.getRating();

        if (updatedMovieName.length() == 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_name_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (updatedMovieGenre.length() == 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_genre_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (updateMovieDirector.length() == 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_director_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (studio == null){
            Toast toast = Toast.makeText(this,R.string.value_toast_studio_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else {
            movieToUpdate.setName(updatedMovieName);
            movieToUpdate.setGenre(updatedMovieGenre);
            movieToUpdate.setDirector(updateMovieDirector);
            movieToUpdate.setStudio(studio);
            movieToUpdate.setActors(arrayListActors);
            movieToUpdate.setRating((int)updatedMovieRating);
            finish();
        }
    }
}
