package com.example.hakanmovieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hakanmovieapp.data.Actor;

public class UpdateActorActivity extends AppCompatActivity {
    EditText editTextUpdatedActorName;
    EditText editTextUpdatedActorAge;
    Spinner spinnerUpdatedActorGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_actor);

        Actor actorToUpdate = TestData.instance.getActorByName(getIntent().getStringExtra(ActorDetailActivity.ACTOR_NAME_OF_TO_UPDATE_ACTOR));

        editTextUpdatedActorName = findViewById(R.id.editTextUpdatedActorName);
        editTextUpdatedActorAge = findViewById(R.id.editTextUpdatedActorAge);
        spinnerUpdatedActorGender = findViewById(R.id.spinnerUpdatedGender);

        editTextUpdatedActorName.setText(actorToUpdate.getName());
        editTextUpdatedActorAge.setText(""+actorToUpdate.getAge());
        ArrayAdapter<CharSequence> genderArrayAdapter = ArrayAdapter.createFromResource(this,R.array.genders,R.layout.support_simple_spinner_dropdown_item);

        spinnerUpdatedActorGender.setAdapter(genderArrayAdapter);
        int positionOfActorGenderInSpinner = getPositionOfSelectedGender(actorToUpdate.getGender());
        if (positionOfActorGenderInSpinner >= 0){
            spinnerUpdatedActorGender.setSelection(positionOfActorGenderInSpinner);
        }

    }

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
}
