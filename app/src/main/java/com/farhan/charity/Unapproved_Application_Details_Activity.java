package com.farhan.charity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Unapproved_Application_Details_Activity extends AppCompatActivity {
    TextView applicantsNameTV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unapproved__application__details);

        applicantsNameTV1 = findViewById(R.id.applicantsNameTV);

        applicantsNameTV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Unapproved_Application_Details_Activity.this, ProfilewithPermanentAddressActivity.class));
            }
        });
    }
}
