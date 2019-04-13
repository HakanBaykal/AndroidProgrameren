package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hakanmovieapp.data.Studio;

public class AddStudioActivity extends AppCompatActivity {

    TextView textViewNewStudioName;
    TextView textViewNewStudioFounder;
    TextView textViewNewStudioOwnerCompany;

    EditText editTextNewStudioName;
    EditText editTextNewStudioFounder;
    EditText editTextNewStudioOwnerCompany;

    Button buttonSaveNewStudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_studio);


        textViewNewStudioName = findViewById(R.id.textViewNewStudioName);
        textViewNewStudioFounder =findViewById(R.id.textViewNewStudioFounder);
        textViewNewStudioOwnerCompany =findViewById(R.id.textViewNewStudioOwnerCompany);

        textViewNewStudioName.setText(R.string.value_textview_studio_name);
        textViewNewStudioFounder.setText(R.string.value_textview_studio_founder);
        textViewNewStudioOwnerCompany.setText(R.string.value_textview_studio_owner_company);

        editTextNewStudioName = findViewById(R.id.editTextNewStudioName);
        editTextNewStudioFounder = findViewById(R.id.editTextNewStudioFounder);
        editTextNewStudioOwnerCompany = findViewById(R.id.editTextNewStudioOwnerCompany);

        buttonSaveNewStudio =  findViewById(R.id.buttonSaveNewStudio);
        buttonSaveNewStudio.setText(R.string.value_save_button);
    }

    public void saveNewStudio(View view){
        String newStudioName = editTextNewStudioName.getText().toString();
        String newStudioFounder = editTextNewStudioFounder.getText().toString();
        String newStudioOwnerCompany = editTextNewStudioOwnerCompany.getText().toString();

        if (newStudioName.length() == 0){
            Toast toast = Toast.makeText(this, R.string.value_toast_name_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }
        if (newStudioFounder.length() == 0){
            Toast toast = Toast.makeText(this, R.string.value_toast_founder_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }
        if (newStudioOwnerCompany.length() == 0){
            Toast toast = Toast.makeText(this, R.string.value_toast_owner_company_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }

        Studio studio = new Studio(newStudioName,newStudioFounder,newStudioOwnerCompany);
        TestData.instance.addStudio(studio);

        setResult(StudioActivity.REQUEST_CODE_ADD_STUDIO);
        this.finish();
    }
}
