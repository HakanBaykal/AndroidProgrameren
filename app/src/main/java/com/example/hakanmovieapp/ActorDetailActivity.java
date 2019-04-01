package com.example.hakanmovieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hakanmovieapp.data.Actor;

public class ActorDetailActivity extends AppCompatActivity {

    ImageView  imageViewDetailActor;
    ImageView imageViewDetailActorGender;

    TextView textViewDetailActorName;
    TextView getTextViewDetailActorAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);

        imageViewDetailActor = findViewById(R.id.imageViewDetailActor);
        imageViewDetailActorGender = findViewById(R.id.imageViewDetailActorGender);
        textViewDetailActorName = findViewById(R.id.textViewDetailActorName);
        getTextViewDetailActorAge = findViewById(R.id.textViewDetailActorAge);

        Actor detailActor =  TestData.instance.getActorByName(getIntent().getStringExtra(ActorActivity.ACTOR_ID_KEY));

        if (imageViewDetailActor != null){
            if (detailActor.hasPicture(this)){
                imageViewDetailActor.setImageResource(this.getResources().getIdentifier("actor_" + detailActor.getName().toLowerCase().replaceAll("\\s+", ""), "drawable", this.getPackageName()));
            }
        }

        if (imageViewDetailActorGender != null){
            if (detailActor.getGender().equals("Female")){
                imageViewDetailActorGender.setImageResource(R.drawable.female);
            }

            if (detailActor.getGender().equals("Male")){
                imageViewDetailActorGender.setImageResource(R.drawable.male);
            }
        }

        if (textViewDetailActorName != null){
            textViewDetailActorName.setText(detailActor.getName());
        }

        if (getTextViewDetailActorAge != null){
            getTextViewDetailActorAge.setText(""+detailActor.getAge());
        }

    }
}
