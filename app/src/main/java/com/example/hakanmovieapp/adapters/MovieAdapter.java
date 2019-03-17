package com.example.hakanmovieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hakanmovieapp.R;
import com.example.hakanmovieapp.data.Movie;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {

    private int resource;

    public MovieAdapter(Context context, int resource, ArrayList<Movie> list) {
        super(context, resource, list);

        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView == null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(this.getContext());
            convertView = inflater.inflate(resource,null);
        }

        Movie listItem = getItem(position);

        if (listItem != null){
            TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            TextView textViewGenre = (TextView) convertView.findViewById(R.id.textViewGenre);

            if (textViewName != null){
                textViewName.setText(listItem.getName());
            }

            if (textViewGenre != null){
                textViewGenre.setText(listItem.getGenre());
            }
        }

        return convertView;
    }
}
