package com.farhan.charity.Dashboard_subItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;
import com.farhan.charity.SubItem_Adapter.ApplicationUnderConsideration_Adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApplicationUnderConsideration extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<ItemModel> items;
    private RequestQueue mRequestQueue;
    SharedPreferences sharedPreferences ;
    String valueNo;
    TextView value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_under_consideration);

        sharedPreferences = this.getSharedPreferences("number", Context.MODE_PRIVATE);
        value = findViewById(R.id.num_69);
        valueNo = sharedPreferences.getString("pending",null);
        value.setText(valueNo);

        items = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ApplicationUnderConsideration.this);
        recyclerView = findViewById(R.id.recyclerView_underConsideration);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
    public void getData() {

        String url = "http://charity.olivineltd.com/api/uno/application?admins_type=UNO&admins_track_id=SKW0V3qiOL20180808114529";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray jsonArray = response.getJSONArray("applicationList");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject applicationList = jsonArray.getJSONObject(i);


                                String applicantName = applicationList.getString("users_name_bn");
                                String applicationAmount = applicationList.getString("application_amount");
                                String application_title_bn = applicationList.getString("application_title_bn");
                                String user_image = applicationList.getString("users_image");
                                String application_id = applicationList.getString("application_id");
                                String application_Staus = applicationList.getString("application_status");
                                ItemModel itemModel = new ItemModel(applicantName, applicationAmount, application_title_bn, user_image);
                                ItemModel test = new ItemModel(applicantName, applicationAmount, application_title_bn, user_image,application_id,application_Staus);
                                items.add(test);
                            }

                            ApplicationUnderConsideration_Adapter adapter = new ApplicationUnderConsideration_Adapter(ApplicationUnderConsideration.this, items);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);


    }

    public void backToPrevious(View view) {
        super.onBackPressed();
    }
}
