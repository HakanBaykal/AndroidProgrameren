package com.example.hakanmovieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hakanmovieapp.data.Studio;

public class UpdateStudioActivity extends AppCompatActivity {

    TextView textViewUpdateStudioName;
    TextView textViewUpdateStudioFounder;
    TextView textViewUpdateStudioOwnerCompany;

    EditText editTextUpdateStudioName;
    EditText editTextUpdateStudioFounder;
    EditText editTextUpdateStudioOwnerCompany;

    Button buttonSaveUpdatedStudio;

    Studio studioToUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_studio);

        studioToUpdate = TestData.instance.getStudioByName(getIntent().getStringExtra(StudioActivity.STUDIO_NAME_FOR_DETAIL));

        textViewUpdateStudioName = findViewById(R.id.textViewUpdateStudioName);
        textViewUpdateStudioName.setText(R.string.value_textview_studio_name);
        textViewUpdateStudioFounder = findViewById(R.id.textViewUpdateStudioFounder);
        textViewUpdateStudioFounder.setText(R.string.value_textview_studio_founder);
        textViewUpdateStudioOwnerCompany = findViewById(R.id.textViewUpdateStudioOwnerCompany);
        textViewUpdateStudioOwnerCompany.setText(R.string.value_textview_studio_owner_company);

        editTextUpdateStudioName =findViewById(R.id.editTextUpdateStudioName);
        editTextUpdateStudioName.setText(studioToUpdate.getName());
        editTextUpdateStudioFounder =findViewById(R.id.editTextUpdateStudioFounder);
        editTextUpdateStudioFounder.setText(studioToUpdate.getFounder());
        editTextUpdateStudioOwnerCompany =findViewById(R.id.editTextUpdateStudioOwnerCompany);
        editTextUpdateStudioOwnerCompany.setText(studioToUpdate.getOwnerCompany());

        buttonSaveUpdatedStudio = findViewById(R.id.buttonSaveUpdateStudio);
        buttonSaveUpdatedStudio.setText(R.string.value_save_button);

    }

    public void saveUpdatedStudio(View view){
        String updatedStudioName = editTextUpdateStudioName.getText().toString();
        String updatedStudioFounder =  editTextUpdateStudioFounder.getText().toString();
        String updatedStudioOwnerCompany = editTextUpdateStudioOwnerCompany.getText().toString();

        if (updatedStudioName.length() == 0){
            Toast toast = Toast.makeText(this, R.string.value_toast_name_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (updatedStudioFounder.length() == 0){
            Toast toast = Toast.makeText(this, R.string.value_toast_founder_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else if (updatedStudioOwnerCompany.length() == 0){
            Toast toast = Toast.makeText(this, R.string.value_toast_owner_company_forgotten,Toast.LENGTH_SHORT);
            toast.show();
        }else{
            studioToUpdate.setName(updatedStudioName);
            studioToUpdate.setFounder(updatedStudioFounder);
            studioToUpdate.setOwnerCompany(updatedStudioOwnerCompany);

            finish();
        }

    }
}
