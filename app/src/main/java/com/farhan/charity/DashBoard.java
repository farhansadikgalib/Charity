package com.farhan.charity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

public class DashBoard extends AppCompatActivity {


    public static final int[] colordata = {
            rgb("#FF2531"), rgb("#0B287B"), rgb("#02AFAE"), rgb("#FEA200")};

    public static final int colorwhite = rgb("#ffffff");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        imageSlider();
        pieChartFuntion();


    }


    public void imageSlider() {
        ImageSlider imageSlider = findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.coverpic_001));
        slideModels.add(new SlideModel(R.drawable.coverpic_001));
        slideModels.add(new SlideModel(R.drawable.coverpic_001));
        slideModels.add(new SlideModel(R.drawable.coverpic_001));
        imageSlider.setImageList(slideModels, true);

    }


    public void pieChartFuntion() {

                PieChart pieChart = findViewById(R.id.piechart);
                PieDataSet pieDataSet = new PieDataSet(getData(), "");

                pieChart.setDrawEntryLabels(true);
                pieDataSet.setColors(colordata);
                PieData pieData = new PieData(pieDataSet);

                pieChart.setHoleRadius(40);
                pieChart.setUsePercentValues(true);
                pieData.setValueTextSize(13f);
                pieChart.setEntryLabelTextSize(8f);
                pieChart.setEntryLabelColor(colorwhite);
                pieData.setValueTextColor(colorwhite);
                pieChart.setTransparentCircleRadius(0);
                pieChart.setData(pieData);
                pieChart.animateXY(3000, 3000);
                pieChart.invalidate();

            }

            private ArrayList getData() {
                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry(30, "শিক্ষা সংক্রান্ত"));
                entries.add(new PieEntry(40, "প্রতিবন্ধী সংক্রান্ত"));
                entries.add(new PieEntry(60, " স্বাস্থ্য সংক্রান্ত"));
                entries.add(new PieEntry(70, "দুর্যোগ সংক্রান্ত"));
                return entries;
            }


}



