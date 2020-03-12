package com.farhan.charity.Dashboard_Items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.farhan.charity.DashbordAdapter.DashbordRecyclerViewAdapter;
import com.farhan.charity.DashbordAdapter.DataModel;
import com.farhan.charity.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

public class HealthRelatedActivity extends AppCompatActivity {
    public static final int[] colordata = {
            rgb("#FF2531"), rgb("#0B287B"), rgb("#02AFAE"), rgb("#FEA200")};

    public static final int colorwhite = rgb("#ffffff");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_related);
        Recyclerview();

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
    public void Recyclerview() {
        RecyclerView recyclerView;
        DashbordRecyclerViewAdapter mAdapter;
        ArrayList<DataModel> dataModels;
        RecyclerView.LayoutManager layoutManager;
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.stopScroll();
        dataModels = new ArrayList<>();
        dataModels.add(new DataModel("সাম্প্রতিক আবেদন", "১,৫২৮", R.drawable.ic_icon_3));
        dataModels.add(new DataModel("অনুমোদিত আবেদন", "২১,২৫৬", R.drawable.ic_icon_4));
        dataModels.add(new DataModel("বিবেচনাধীন আবেদন", "৮৫১", R.drawable.ic_icon_2));
        dataModels.add(new DataModel("অননুমোদিত আবেদন", "২৫", R.drawable.ic_icon_1));
        dataModels.add(new DataModel("পুনরায় জমা আবেদন", "৫", R.drawable.ic_icon_5));
        mAdapter = new DashbordRecyclerViewAdapter(HealthRelatedActivity.this, dataModels);
        recyclerView.setAdapter(mAdapter);

    }

    public void backToPrevious(View view) {
        super.onBackPressed();
    }
}
