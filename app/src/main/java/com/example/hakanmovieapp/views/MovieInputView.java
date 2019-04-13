package com.example.hakanmovieapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hakanmovieapp.R;

public class MovieInputView extends LinearLayout {

    private EditText editTextMovieName;
    private EditText editTextMovieGenre;
    private EditText editTextMovieDirector;

    private TextView textViewInputMovieName;
    private TextView textViewInputMovieGenre;
    private TextView textViewInputMovieDirector;


    public MovieInputView(Context context) {
        super(context);
        initializeViews(context);
    }

    public MovieInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public MovieInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.movie_input_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        editTextMovieName  = (EditText) findViewById(R.id.editTextAddMovieName);
        editTextMovieGenre  = (EditText) findViewById(R.id.editTextAddMovieGenre);
        editTextMovieDirector  = (EditText) findViewById(R.id.editTextAddMovieDirector);

        textViewInputMovieName =findViewById(R.id.textViewMovieInputViewName);
        textViewInputMovieGenre =findViewById(R.id.textViewMovieInputViewGenre);
        textViewInputMovieDirector =findViewById(R.id.textViewMovieInputViewDirector);

        textViewInputMovieName.setText(R.string.value_textview_name);
        textViewInputMovieGenre.setText(R.string.value_textview_genre);
        textViewInputMovieDirector.setText(R.string.value_textview_director);
    }

    public String getAddMovieName(){
        return editTextMovieName.getText().toString();
    }

    public void setAddMovieName(String addMovieName){
        editTextMovieName.setText(addMovieName);
    }

    public String getAddMovieGenre(){
        return editTextMovieGenre.getText().toString();
    }

    public void setAddMovieGenre(String addMovieGenre){
        editTextMovieGenre.setText(addMovieGenre);
    }

    public String getAddMovieDirector(){
        return editTextMovieDirector.getText().toString();
    }

    public void setAddMovieDirector(String addMovieDirector){
        editTextMovieDirector.setText(addMovieDirector);
    }
}
