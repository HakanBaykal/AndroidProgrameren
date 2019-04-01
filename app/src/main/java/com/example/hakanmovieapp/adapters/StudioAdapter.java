package com.example.hakanmovieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hakanmovieapp.R;
import com.example.hakanmovieapp.data.Studio;

import java.util.ArrayList;

public class StudioAdapter extends ArrayAdapter<Studio> {

    private int resource;

    public StudioAdapter(Context context, int resource, ArrayList<Studio> list) {
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

        Studio listItem = getItem(position);

        if (listItem != null){
            TextView textViewName = (TextView) convertView.findViewById(R.id.textViewStudioName);
            TextView textViewGenre = (TextView) convertView.findViewById(R.id.textViewOwner);

            if (textViewName != null){
                textViewName.setText(listItem.getName());
            }

            if (textViewGenre != null){
                textViewGenre.setText(listItem.getOwnerCompany());
            }
        }

        return convertView;
    }

}
