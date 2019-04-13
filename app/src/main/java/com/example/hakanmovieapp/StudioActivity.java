package com.example.hakanmovieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.hakanmovieapp.adapters.StudioAdapter;
import com.example.hakanmovieapp.data.Studio;

import java.util.ArrayList;

public class StudioActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_STUDIO = 633;
    public static final String STUDIO_NAME_FOR_DETAIL = "STUDIO_NAME_FOR_DETAIL";

    ListView studioListview;
    StudioAdapter studioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        studioListview = findViewById(R.id.ListViewStudio);
        studioAdapter = new StudioAdapter(this,R.layout.activity_studio_list_item, TestData.instance.getStudios());
        studioListview.setAdapter(studioAdapter);

        studioListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Studio studio = studioAdapter.getItem(position);
                if (studio != null) {
                    String studioDetailName = studio.getName();

                    Intent intent = new Intent(StudioActivity.this, StudioDetailActivity.class);
                    intent.putExtra(STUDIO_NAME_FOR_DETAIL, studioDetailName);
                    startActivity(intent);
                }
            }
        });

        studioListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TestData.instance.removeStudio(studioAdapter.getItem(position));
                studioAdapter.notifyDataSetChanged();
                return false;
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudioActivity.this,AddStudioActivity.class);
                startActivityForResult(intent,REQUEST_CODE_ADD_STUDIO);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ADD_STUDIO) {
            studioAdapter.notifyDataSetChanged();
        }
    }

}
