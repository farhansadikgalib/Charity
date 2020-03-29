package com.farhan.charity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.farhan.charity.Dashboard_Items.All_Application_Activity;
import com.farhan.charity.Dashboard_Items.ApplicationOf_EducationActivity;
import com.farhan.charity.Dashboard_Items.DisabilityRelatedActivity;
import com.farhan.charity.Dashboard_Items.DisasterRelatedActivity;
import com.farhan.charity.Dashboard_Items.Forward_Application_Activity;
import com.farhan.charity.Dashboard_Items.HealthRelatedActivity;
import com.farhan.charity.Fragment.MainActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

public class DashBoard extends AppCompatActivity {


    public String admins,idx;
    public static String admin_typeS,admins_track_idS;


    public static final int[] colordata = {
            rgb("#FF2531"), rgb("#0B287B"), rgb("#02AFAE"), rgb("#FEA200")};

    public static final int colorwhite = rgb("#ffffff");

    LinearLayout educationLayout,climateLayout,disabilityLayout,healthLayout;
    ConstraintLayout allApplicationLayout,forwardApplicationLayout;
    private RequestQueue mRequestQueue;

    String education , disable , disaster , health ;
    LinearLayout linerPieChart ;
    int i , j , k , l ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        imageSlider();
        pieChartFuntion();
        buttonIDsetFuction();
        buttonClickListenersetFunction();
        mRequestQueue = Volley.newRequestQueue(this);

        PieChartParsex();



    }



    public void imageSlider() {
//        ImageSlider imageSlider = findViewById(R.id.slider);
//
//        List<SlideModel> slideModels = new ArrayList<>();
//        slideModels.add(new SlideModel(R.drawable.coverpic101));
////        slideModels.add(new SlideModel(R.drawable.coverpic101));
////        slideModels.add(new SlideModel(R.drawable.coverpic101));
////        slideModels.add(new SlideModel(R.drawable.coverpic101));
//        imageSlider.setImageList(slideModels, false);

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
                entries.add(new PieEntry(i, "শিক্ষা সংক্রান্ত"));
                entries.add(new PieEntry(j, "প্রতিবন্ধী সংক্রান্ত"));
                entries.add(new PieEntry(k, " স্বাস্থ্য সংক্রান্ত"));
                entries.add(new PieEntry(l, "দুর্যোগ সংক্রান্ত"));
                return entries;
            }

            public void buttonIDsetFuction(){

                educationLayout = findViewById(R.id.educationApplicationBT);
                climateLayout = findViewById(R.id.climateRelatedBT);
                disabilityLayout = findViewById(R.id.disabilityRelatedBT);
                healthLayout = findViewById(R.id.healthRelatedBT);

                allApplicationLayout = findViewById(R.id.allApplicationBT);
                forwardApplicationLayout = findViewById(R.id.forwardApplicationBT);

          }

            public void buttonClickListenersetFunction(){

                educationLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      //  startActivity(new Intent(DashBoard.this, ApplicationOf_EducationActivity.class));



                        Intent i = new Intent(DashBoard.this, ApplicationOf_EducationActivity.class);

                        i.putExtra("User_Type",admin_typeS);

                        i.putExtra("User_Track_ID",admins_track_idS);

                        startActivity(i);

                    }
                });

                climateLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     //   startActivity(new Intent(DashBoard.this, DisasterRelatedActivity.class));

                        Intent i = new Intent(DashBoard.this, DisasterRelatedActivity.class);
                        i.putExtra("User_Type",admin_typeS);
                        i.putExtra("User_Track_ID",admins_track_idS);
                        startActivity(i);


                    }
                });

                disabilityLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      //  startActivity(new Intent(DashBoard.this, DisabilityRelatedActivity.class));

                        Intent i = new Intent(DashBoard.this, DisabilityRelatedActivity.class);
                        i.putExtra("User_Type",admin_typeS);
                        i.putExtra("User_Track_ID",admins_track_idS);
                        startActivity(i);


                    }
                });

                healthLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      //  startActivity(new Intent(DashBoard.this, HealthRelatedActivity.class));

                        Intent i = new Intent(DashBoard.this, HealthRelatedActivity.class);
                        i.putExtra("User_Type",admin_typeS);
                        i.putExtra("User_Track_ID",admins_track_idS);
                        startActivity(i);

                    }
                });

                allApplicationLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DashBoard.this, All_Application_Activity.class));
                    }
                });

                forwardApplicationLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DashBoard.this, Forward_Application_Activity.class));
                    }
                });


            }



    private void PieChartParsex() {

        String url = "http://charity.olivineltd.com/api/dashboard?admins_type="+admins+"&admins_track_id="+idx ;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //      Toast.makeText(DashBoard.this,response.toString(),Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObject = (JSONObject) response.get("pieChart");
                    education = jsonObject.get("education").toString();
                    health = jsonObject.get("health").toString();
                    disable = jsonObject.get("disable").toString();
                    disaster = jsonObject.get("disaster").toString();

                    //Toast.makeText(DashBoard.this, education, Toast.LENGTH_SHORT).show();

                    i = Integer.parseInt(education);
                    j = Integer.parseInt(disable);
                    k = Integer.parseInt(health);
                    l = Integer.parseInt(disaster);

                    //Toast.makeText(DashBoard.this, ""+i+j+k+l, Toast.LENGTH_SHORT).show();

                    if( i == 0 && j == 0 && k == 0 && l == 0 )
                    {
                       linerPieChart.setVisibility(View.GONE);
                    }
                    else {
                       pieChartFuntion();
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());
            }
        });

        mRequestQueue.add(request);
    }


    @Override
    protected void onStart() {
        super.onStart();

        admins = getIntent().getStringExtra("User_Type").toString();
        idx = getIntent().getStringExtra("User_Track_ID").toString();
     //   Toast.makeText(this, ""+admins+"\n"+idx, Toast.LENGTH_SHORT).show();


    }
}






