package com.farhan.charity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.farhan.charity.Dashboard_Items.ApplicationOf_EducationActivity;

public class UnderConsideration_Details_Activity extends AppCompatActivity {

    TextView applicantsNameTV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_consideration__details_);

        applicantsNameTV1 = findViewById(R.id.applicantsNameTV);

        applicantsNameTV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UnderConsideration_Details_Activity.this, ProfilewithPermanentAddressActivity.class));
            }
        });
    }
}
