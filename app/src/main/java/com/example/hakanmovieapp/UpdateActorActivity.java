package com.example.hakanmovieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hakanmovieapp.data.Actor;

public class UpdateActorActivity extends AppCompatActivity {
    EditText editTextUpdatedActorName;
    EditText editTextUpdatedActorAge;
    Spinner spinnerUpdatedActorGender;

    Actor actorToUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_actor);

        actorToUpdate = TestData.instance.getActorByName(getIntent().getStringExtra(ActorDetailActivity.ACTOR_NAME_OF_TO_UPDATE_ACTOR));

        editTextUpdatedActorName = findViewById(R.id.editTextUpdatedActorName);
        editTextUpdatedActorAge = findViewById(R.id.editTextUpdatedActorAge);
        spinnerUpdatedActorGender = findViewById(R.id.spinnerUpdatedGender);

        editTextUpdatedActorName.setText(actorToUpdate.getName());
        editTextUpdatedActorAge.setText(""+actorToUpdate.getAge());
        ArrayAdapter<CharSequence> genderArrayAdapter = ArrayAdapter.createFromResource(this,R.array.genders,R.layout.support_simple_spinner_dropdown_item);

        spinnerUpdatedActorGender.setAdapter(genderArrayAdapter);
        int positionOfActorGenderInSpinner = getPositionOfSelectedGender(actorToUpdate.getGender());
        if (positionOfActorGenderInSpinner >= 0){
            // de acteur zn gender wordt gezet
            spinnerUpdatedActorGender.setSelection(positionOfActorGenderInSpinner);
        }

    }

    //hier wordt over de spinner gelooped om de positie van het gekozen gender te vinden
    public int getPositionOfSelectedGender(String gender){
        int spinnerSize = spinnerUpdatedActorGender.getAdapter().getCount();

        for (int i = 0; i < spinnerSize; i++){
            String spinnerItemTocheck = spinnerUpdatedActorGender.getItemAtPosition(i).toString();
            if (spinnerItemTocheck.equals(gender)) {
                return i;
            }

        }
        return -1;
    }


    public void saveUpdatedActor(View view){
        String updatedActorName = editTextUpdatedActorName.getText().toString();
        int updatedActorAge =  Integer.parseInt(editTextUpdatedActorAge.getText().toString());
        String updatedActorGender =  spinnerUpdatedActorGender.getSelectedItem().toString();

        if (updatedActorName.length() == 0){
            Toast toast = Toast.makeText(this,R.string.value_toast_name_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (updatedActorAge <= 0) {
            Toast toast = Toast.makeText(this, R.string.value_toast_age_forgotten, Toast.LENGTH_SHORT);
            toast.show();
        }else {
            actorToUpdate.setName(updatedActorName);
            actorToUpdate.setAge(updatedActorAge);
            actorToUpdate.setGender(updatedActorGender);
            finish();
        }
    }
}
