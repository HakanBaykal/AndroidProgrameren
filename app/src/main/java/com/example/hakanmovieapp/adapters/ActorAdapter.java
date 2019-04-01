package com.example.hakanmovieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hakanmovieapp.R;
import com.example.hakanmovieapp.data.Actor;

import java.util.ArrayList;

public class ActorAdapter extends ArrayAdapter<Actor> {

    private int resource;

    public ActorAdapter(Context context, int resource, ArrayList<Actor> list) {
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

        Actor listItem = getItem(position);

        if (listItem != null){
            TextView textViewActorName = (TextView) convertView.findViewById(R.id.textViewMovieName);
            TextView textViewGenre = (TextView) convertView.findViewById(R.id.textViewAge);
            ImageView imageViewActor = (ImageView) convertView.findViewById(R.id.imageViewActor);

            if (textViewActorName != null){
                textViewActorName.setText(listItem.getName());
            }

            if (textViewGenre != null){
                textViewGenre.setText(""+listItem.getAge());
            }

            if (imageViewActor != null){
                if (listItem.hasPicture(getContext())){
                    imageViewActor.setImageResource(getContext().getResources().getIdentifier("actor_"+listItem.getName().toLowerCase().replaceAll("\\s+",""), "drawable", getContext().getPackageName()));
                }else {
                    imageViewActor.setImageResource(R.drawable.notfound);
                }

            }
        }

        return convertView;
    }
}
