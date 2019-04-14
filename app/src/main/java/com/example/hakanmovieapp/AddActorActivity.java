package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hakanmovieapp.data.Actor;

public class AddActorActivity extends AppCompatActivity {

    EditText editTextActorName;
    EditText editTextActorAge;
    Spinner spinnerActorGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_actor);

        editTextActorName = findViewById(R.id.editTextActorName);
        editTextActorAge =findViewById(R.id.editTextActorAge);
        spinnerActorGender = findViewById(R.id.spinnerGender);

        //hier is een arrayAdapter die alle gender uit mijn string.xml halen en in met spinner stoppen
        ArrayAdapter<CharSequence> genderArrayAdapter = ArrayAdapter.createFromResource(this,R.array.genders,R.layout.support_simple_spinner_dropdown_item);
        spinnerActorGender.setAdapter(genderArrayAdapter);
    }

    public void addActor(View view){
        String newActorName = editTextActorName.getText().toString();
        int newActorAge = Integer.parseInt(editTextActorAge.getText().toString());
        String newActorGender = spinnerActorGender.getSelectedItem().toString();

        if (newActorName.length() == 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_name_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if(newActorAge < 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_age_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Actor actor = new Actor(newActorName,newActorAge,newActorGender);
            TestData.instance.addActor(actor);

            Intent intent = new Intent();
            setResult(ActorActivity.ACTOR_ADD_RESULT_CODE,intent);
            finish();
        }
    }


}
