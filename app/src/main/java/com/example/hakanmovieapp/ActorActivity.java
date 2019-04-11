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

import com.example.hakanmovieapp.adapters.ActorAdapter;
import com.example.hakanmovieapp.data.Actor;

import java.util.ArrayList;

public class ActorActivity extends AppCompatActivity {

    public static final String ACTOR_ID_KEY =  "id_key";

    public static final int ACTOR_ADD_RESULT_CODE = 1234;

    ListView actorListView;

    ActorAdapter actorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        actorListView = findViewById(R.id.ListViewActor);
        actorAdapter = new ActorAdapter(this, R.layout.activity_actor__list__item, TestData.instance.getActors());
        actorListView.setAdapter(actorAdapter);
        actorListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Actor a = (Actor) parent.getItemAtPosition(position);

                Intent intent = new Intent(ActorActivity.this, ActorDetailActivity.class);
                intent.putExtra(ACTOR_ID_KEY,a.getName());

                startActivity(intent);
            }
        });

        actorListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TestData.instance.removeActor(actorAdapter.getItem(position));
                actorAdapter.notifyDataSetChanged();
                return false;
            }
        });

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActorActivity.this,AddActorActivity.class);
                startActivityForResult(intent,ACTOR_ADD_RESULT_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            if (requestCode == ACTOR_ADD_RESULT_CODE) {
                actorAdapter.notifyDataSetChanged();
            }
        }
    }

}
