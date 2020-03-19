package com.farhan.charity.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.farhan.charity.R;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frameLayout = findViewById(R.id.registration_framelayout);

        setFragment(new SignInFragment());

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayout.getId(), fragment);
        ft.commit();

    }

    public void backToPrevious(View view) {
        super.onBackPressed();
    }
}