package com.farhan.charity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Unapproved_Application_Details_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unapproved__application__details);
    }
    public void backToPreviouss(View view) {
        super.onBackPressed();
    }
}
