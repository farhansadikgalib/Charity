package com.farhan.charity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.farhan.charity.Dashboard_Items.Forward_Application_Activity;

public class Applicant_Details extends AppCompatActivity {
    Button forwardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_details);

        forwardBtn=findViewById(R.id.forwardBtn);

        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Applicant_Details.this, FowardForm.class));
            }
        });
    }
}
