package com.example.hakanmovieapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    TextView textViewSplashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textViewSplashScreen = findViewById(R.id.textViewSplashScreen);
        textViewSplashScreen.setText(R.string.app_name);

        //hier wordt met een postDelayed na 1,5 sec een finish aangeroepen
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startMainActivity();
                finish();
            }
        }, 1500);



    }

    private void startMainActivity(){
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}
