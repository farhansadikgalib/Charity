package com.farhan.charity.Dashboard_Items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.DashbordAdapter.DashbordRecyclerViewAdapter;
import com.farhan.charity.DashbordAdapter.DataModel;
import com.farhan.charity.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

public class DisasterRelatedActivity extends AppCompatActivity {

    public static final int[] colordata = {
            rgb("#FF2531"), rgb("#0B287B"), rgb("#02AFAE"),
            rgb("#a53118"),rgb("#FEA200")};

    public static final int colorwhite = rgb("#ffffff");
    String education , disable , disaster , health ;
    String submitted , approved , resubmitted , rejected,pending ;
    public static String admins,idx;
    LinearLayout linerPieChart ;
    RequestQueue mRequestQueue;

    SharedPreferences sharedPreferences ;

    int i , j , k , l,p,q,r,s,t ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_related);
        sharedPreferences = this.getSharedPreferences("number", Context.MODE_PRIVATE);
//        Recyclerview();
//        pieChartFuntion();
        mRequestQueue = Volley.newRequestQueue(this);
        catDashboardInfoparse();
    }

    private ArrayList getData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(p, "সাম্প্রতিক"));
        entries.add(new PieEntry(q, "অনুমোদিত"));
        entries.add(new PieEntry(t, "বিবেচনাধীন"));
        entries.add(new PieEntry(s, "অননুমোদিত"));
        entries.add(new PieEntry(r, "পুনরায় জমা"));
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
        dataModels.add(new DataModel("সাম্প্রতিক আবেদন", submitted, R.drawable.ic_icon_3));
        dataModels.add(new DataModel("অনুমোদিত আবেদন", approved, R.drawable.ic_icon_4));
        dataModels.add(new DataModel("বিবেচনাধীন আবেদন", pending, R.drawable.ic_icon_2));
        dataModels.add(new DataModel("অননুমোদিত আবেদন",rejected , R.drawable.ic_icon_1));
        dataModels.add(new DataModel("পুনরায় জমা আবেদন", resubmitted, R.drawable.ic_icon_5));
        mAdapter = new DashbordRecyclerViewAdapter(DisasterRelatedActivity.this, dataModels);
        recyclerView.setAdapter(mAdapter);

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
    private void catDashboardInfoparse() {


        String url = "http://charity.olivineltd.com/api/dashboardCat?application_service_id=df" ;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //      Toast.makeText(DashBoard.this,response.toString(),Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonObject = (JSONObject) response.get("catDashboardInfo");
                    submitted = jsonObject.get("submitted").toString();
                    approved = jsonObject.get("approved").toString();
                    resubmitted = jsonObject.get("resubmitted").toString();
                    rejected = jsonObject.get("rejected").toString();
                    pending = jsonObject.get("pending").toString();

                    //      Toast.makeText(getApplicationContext(), education, Toast.LENGTH_SHORT).show();

                    p = Integer.parseInt(submitted);
                    q = Integer.parseInt(approved);
                    r = Integer.parseInt(resubmitted);
                    s = Integer.parseInt(rejected);
                    t = Integer.parseInt(pending);

                    sharedPreferences.edit().putString("submitted",submitted).apply();
                    sharedPreferences.edit().putString("approved",approved).apply();
                    sharedPreferences.edit().putString("resubmitted",resubmitted).apply();
                    sharedPreferences.edit().putString("rejected",rejected).apply();
                    sharedPreferences.edit().putString("pending",pending).apply();

                    //     Toast.makeText(getApplicationContext(), ""+i+j+k+l, Toast.LENGTH_SHORT).show();

                    if( p == 0 && q == 0 && r == 0 && s == 0 && t==0)
                    {
                        linerPieChart.setVisibility(View.GONE);
                    }
                    else {
                        pieChartFuntion();
                    }

                    Recyclerview();

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

        admins = getIntent().getStringExtra("User_Type");
        idx = getIntent().getStringExtra("User_Track_ID");
     //   Toast.makeText(this, ""+admins+"\n"+idx, Toast.LENGTH_SHORT).show();



    }

    public void backToPrevious(View view) {
        super.onBackPressed();
    }
}
