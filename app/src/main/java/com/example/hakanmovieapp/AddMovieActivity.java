package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.hakanmovieapp.adapters.StudioAdapter;
import com.example.hakanmovieapp.data.Actor;
import com.example.hakanmovieapp.data.Movie;
import com.example.hakanmovieapp.data.Studio;

import java.util.ArrayList;

public class AddMovieActivity extends AppCompatActivity {

    public static  final int RESULT_CODE = 1;
    public static final String RESULT_ARRAY_LIST_ACTORS = "actor_array_list";

    private EditText editTextName;

    private EditText editTextGenre;

    private EditText editTextDirector;

    private RatingBar ratingBar;

    private ListView listViewStudios;

    private ArrayList<Actor> arrayListActors;

    private Studio studio = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        editTextName = findViewById(R.id.editText);
        editTextGenre  = findViewById(R.id.editTextGenre);
        editTextDirector = findViewById(R.id.editTextDirector);
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
        if (editTextName.getText().length() == 0){
            Toast toast = Toast.makeText(this,"Name is verplicht",Toast.LENGTH_SHORT);
            toast.show();
        }else if (editTextGenre.getText().length() == 0){
            Toast toast = Toast.makeText(this,"Genre is verplicht",Toast.LENGTH_SHORT);
            toast.show();
        }else if (editTextDirector.getText().length() == 0){
            Toast toast = Toast.makeText(this,"Director is verplicht",Toast.LENGTH_SHORT);
            toast.show();
        }else if (studio == null){
            Toast toast = Toast.makeText(this,"Studio is verplicht",Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Movie newMovie = new Movie(editTextName.getText().toString(), editTextGenre.getText().toString(), editTextDirector.getText().toString(), studio, (int)ratingBar.getRating());
            for (Actor a : arrayListActors){
                newMovie.addActor(a);
            }
            TestData.instance.addMovie(newMovie);
            finish();
        }
    }

}
