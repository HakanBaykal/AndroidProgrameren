package com.example.hakanmovieapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.hakanmovieapp.R;

public class MovieInputView extends LinearLayout {
    private EditText editTextMovieName;
    private EditText editTextMovieGenre;
    private EditText editTextMovieDirector;


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

        editTextMovieName  = (EditText) findViewById(R.id.editText);
        editTextMovieGenre  = (EditText) findViewById(R.id.editText2);
        editTextMovieDirector  = (EditText) findViewById(R.id.editText3);
    }
}
