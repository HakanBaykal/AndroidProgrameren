package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hakanmovieapp.data.Actor;

public class ActorDetailActivity extends AppCompatActivity {

    public static final String ACTOR_NAME_OF_TO_UPDATE_ACTOR = "ACTOR_NAME_OF_TO_UPDATE_ACTOR";

    Button buttonEditActor;

    ImageView  imageViewDetailActor;
    ImageView imageViewDetailActorGender;

    TextView textViewDetailActorName;
    TextView getTextViewDetailActorAge;

    Actor detailActor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);

        buttonEditActor = findViewById(R.id.buttonEditActor);
        buttonEditActor.setText(R.string.value_edit_button);
        imageViewDetailActor = findViewById(R.id.imageViewDetailActor);
        imageViewDetailActorGender = findViewById(R.id.imageViewDetailActorGender);
        textViewDetailActorName = findViewById(R.id.textViewDetailActorName);
        getTextViewDetailActorAge = findViewById(R.id.textViewDetailActorAge);

        detailActor =  TestData.instance.getActorByName(getIntent().getStringExtra(ActorActivity.ACTOR_ID_KEY));

        if (imageViewDetailActor != null){
            if (detailActor.hasPicture(this)){
                //hier wordt het resource id van een drawable opgehaaldop basis van de acteurs zn naam en in de imageview gestopt
                imageViewDetailActor.setImageResource(this.getResources().getIdentifier("actor_" + detailActor.getName().toLowerCase().replaceAll("\\s+", ""), "drawable", this.getPackageName()));
            }else {
                imageViewDetailActor.setImageResource(R.drawable.notfound);
            }
        }

        if (imageViewDetailActorGender != null){
            if (detailActor.getGender().equals("Female")){
                //hier wordt het resource id van een drawable opgehaaldop basis van de acteurs zn gender en in de imageview gestopt
                imageViewDetailActorGender.setImageResource(R.drawable.female);
            }

            if (detailActor.getGender().equals("Male")){
                //hier wordt het resource id van een drawable opgehaaldop basis van de acteurs zn gender en in de imageview gestopt
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

    public void openActorUpdateActivity(View view){
        Intent intent =  new Intent(this, UpdateActorActivity.class);
        intent.putExtra(ACTOR_NAME_OF_TO_UPDATE_ACTOR,detailActor.getName());
        startActivity(intent);
        finish();
    }
}
