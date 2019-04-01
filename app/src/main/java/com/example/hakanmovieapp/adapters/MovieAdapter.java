package com.example.hakanmovieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
            TextView textViewName = (TextView) convertView.findViewById(R.id.textViewMovieName);
            TextView textViewGenre = (TextView) convertView.findViewById(R.id.textViewGenre);
            ImageView imageViewMovie = (ImageView) convertView.findViewById(R.id.imageViewMovie);

            if (textViewName != null){
                textViewName.setText(listItem.getName());
            }

            if (textViewGenre != null){
                textViewGenre.setText(listItem.getGenre());
            }

            if (imageViewMovie != null){
                if (listItem.hasPicture(getContext())){
                    imageViewMovie.setImageResource(getContext().getResources().getIdentifier("movie_"+listItem.getName().toLowerCase().replaceAll("\\s+",""), "drawable", getContext().getPackageName()));
                }else {
                    imageViewMovie.setImageResource(R.drawable.notfound);
                }
            }
        }

        return convertView;
    }
}
