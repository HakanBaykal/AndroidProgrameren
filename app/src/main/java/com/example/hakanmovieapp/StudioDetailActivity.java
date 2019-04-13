package com.example.hakanmovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hakanmovieapp.data.Studio;

public class StudioDetailActivity extends AppCompatActivity {

    TextView textViewDetailStudioNameHeader;
    TextView textViewDetailStudioName;
    TextView textViewDetailStudioFounderHeader;
    TextView textViewDetailStudioFounder;
    TextView textViewDetailStudioOwnerCompanyHeader;
    TextView textViewDetailStudioOwnerCompany;

    Button buttonEditStudio;

    Studio detailStudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio_detail);

        detailStudio = TestData.instance.getStudioByName(getIntent().getStringExtra(StudioActivity.STUDIO_NAME_FOR_DETAIL));

        textViewDetailStudioNameHeader = findViewById(R.id.textViewDetailStudioNameHeader);
        textViewDetailStudioNameHeader.setText(R.string.value_textview_studio_name);
        textViewDetailStudioName = findViewById(R.id.textViewDetailStudioName);
        textViewDetailStudioFounderHeader = findViewById(R.id.textViewDetailStudioFounderHeader);
        textViewDetailStudioFounderHeader.setText(R.string.value_textview_studio_founder);
        textViewDetailStudioFounder = findViewById(R.id.textViewDetailStudioFounder);
        textViewDetailStudioOwnerCompanyHeader = findViewById(R.id.textViewDetailStudioOwnerCompanyHeader);
        textViewDetailStudioOwnerCompanyHeader.setText(R.string.value_textview_studio_owner_company);
        textViewDetailStudioOwnerCompany = findViewById(R.id.textViewDetailStudioOwnerCompany);

        buttonEditStudio =  findViewById(R.id.buttonEditStudio);
        buttonEditStudio.setText(R.string.value_edit_button);

        if (detailStudio != null){
            textViewDetailStudioName.setText(detailStudio.getName());
            textViewDetailStudioFounder.setText(detailStudio.getFounder());
            textViewDetailStudioOwnerCompany.setText(detailStudio.getOwnerCompany());
        }
    }

    public void openUpdateStudioActivity(View view){
        Intent intent = new Intent(this,UpdateStudioActivity.class);
        intent.putExtra(StudioActivity.STUDIO_NAME_FOR_DETAIL, detailStudio.getName());

        startActivity(intent);
        finish();
    }
}
