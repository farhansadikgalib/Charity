package com.farhan.charity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.Adapter.Unapproved_Adapter;
import com.farhan.charity.Dashbor_subItem.ApplicationUnderConsideration;
import com.farhan.charity.Dashbor_subItem.UnapprovedApplication;
import com.farhan.charity.SubItem_Adapter.ApplicationUnApproved_Adapter;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.SubItem_Adapter.ApplicationUnderConsideration_Adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Under_consideration_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<ItemModel> items;
    private RequestQueue mRequestQueue;
    private ApplicationUnderConsideration_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_consideration);
        mRequestQueue = Volley.newRequestQueue(this);
        items = new ArrayList<>();
        adapter = new ApplicationUnderConsideration_Adapter(Under_consideration_Activity.this,items);
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Under_consideration_Activity.this);
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

                            Toast.makeText(Under_consideration_Activity.this, "Hello "+response, Toast.LENGTH_SHORT).show();
                            JSONArray jsonArray = response.getJSONArray("applicationList");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject applicationList = jsonArray.getJSONObject(i);


                                //String profileImg = hit.getString("webformatURL");
                                String applicantName = applicationList.getString("users_name_bn");
                                String applicationAmount = applicationList.getString("application_amount");
                                String application_title_bn = applicationList.getString("application_title_bn");
                                String user_image = applicationList.getString("users_image");
                                ItemModel itemModel = new ItemModel(applicantName, applicationAmount, application_title_bn, user_image);
                                items.add(itemModel);
                            }
                            adapter = new ApplicationUnderConsideration_Adapter(Under_consideration_Activity.this,items);
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

    public void backToApplicantsDetails(View view) {
        super.onBackPressed();
    }
}
