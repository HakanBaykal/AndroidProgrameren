package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hakanmovieapp.adapters.ActorAdapter;
import com.example.hakanmovieapp.data.Actor;

import java.util.ArrayList;

public class AddMovieActorActivity extends AppCompatActivity {

    private ArrayList<Actor> actorsAdded;
    private ArrayList<Actor> actorsToAdd;

    private ListView listViewActorsAdded;
    private ListView listViewActorsToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie_actor);
        actorsAdded = new ArrayList<>();
        for (String actorName : getIntent().getStringArrayListExtra(AddMovieActivity.RESULT_ARRAY_LIST_ACTORS)){
            if (!actorAlreadyAdded(actorName)){
                actorsAdded.add(TestData.instance.getActorByName(actorName));
            }

        }
        actorsToAdd = new ArrayList<>();
        for (Actor a : TestData.instance.getActors()){
            if (!actorAlreadyAdded(a.getName())){
                actorsToAdd.add(a);
            }
        }

        listViewActorsAdded = findViewById(R.id.ListViewActorsAdded);
        listViewActorsToAdd = findViewById(R.id.ListviewActorsToAdd);

        final ActorAdapter actorAdapterActorsAdded = new ActorAdapter(this, R.layout.activity_actor__list__item,actorsAdded);
        final ActorAdapter actorAdapterActorsToAdd = new ActorAdapter(this,R.layout.activity_actor__list__item,actorsToAdd);

        listViewActorsAdded.setAdapter(actorAdapterActorsAdded);
        listViewActorsToAdd.setAdapter(actorAdapterActorsToAdd);

        listViewActorsToAdd.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Actor a = (Actor) parent.getItemAtPosition(position);

                actorsToAdd.remove(position);
                actorsAdded.add(a);


                actorAdapterActorsAdded.notifyDataSetChanged();
                actorAdapterActorsToAdd.notifyDataSetChanged();
            }
        });

        listViewActorsAdded.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Actor a = (Actor) parent.getItemAtPosition(position);

                actorsToAdd.add(a);
                actorsAdded.remove(position);

                actorAdapterActorsAdded.notifyDataSetChanged();
                actorAdapterActorsToAdd.notifyDataSetChanged();
            }
        });


    }

    public void saveActors(View view){
        ArrayList<String> ActorNames = new ArrayList<>();
        for (Actor a : actorsAdded){
            ActorNames.add(a.getName());
        }
        Intent intent = new Intent();
        intent.putExtra(AddMovieActivity.RESULT_ARRAY_LIST_ACTORS,ActorNames);
        setResult(AddMovieActivity.RESULT_CODE,intent);
        finish();
    }

    private Boolean actorAlreadyAdded(String actorName){
        for (Actor a : actorsAdded){
            if (a.getName().equals(actorName)){
                return true;
            }
        }
        return false;
    }
}

