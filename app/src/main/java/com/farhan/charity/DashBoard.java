package com.farhan.charity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;
import java.util.List;


public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


        ImageSlider imageSlider = findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.dashboard_cp1_new));
        slideModels.add(new SlideModel(R.drawable.dashboard_cp1_new));
        slideModels.add(new SlideModel(R.drawable.dashboard_cp1_new));
        slideModels.add(new SlideModel(R.drawable.dashboard_cp1_new));
        imageSlider.setImageList(slideModels, true);
    }
}