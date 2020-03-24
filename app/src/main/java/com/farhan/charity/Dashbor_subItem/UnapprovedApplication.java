package com.farhan.charity.Dashbor_subItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.Adapter.Adapter_item1;
import com.farhan.charity.Adapter.Unapproved_Adapter;
import com.farhan.charity.Dashboard_Items.All_Application_Activity;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UnapprovedApplication extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ItemModel> items;
    private Unapproved_Adapter unapproved_adapter;

    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unapproved_application);
        items = new ArrayList<>();
        unapproved_adapter = new Unapproved_Adapter(this, items);

        mRequestQueue = Volley.newRequestQueue(this);
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UnapprovedApplication.this);
        recyclerView = findViewById(R.id.recyclerView_unapproved);
        recyclerView.setLayoutManager(linearLayoutManager);


        // Unapproved_Adapter adapter = new Unapproved_Adapter(UnapprovedApplication.this, items);
        //recyclerView.setAdapter(adapter);
    }

    public void getData() {

        String url = "http://charity.olivineltd.com/api/uno/application?admins_type=UNO&admins_track_id=SKW0V3qiOL20180808114529";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            //Toast.makeText(UnapprovedApplication.this, "Hello "+response, Toast.LENGTH_SHORT).show();
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

                            unapproved_adapter = new Unapproved_Adapter(UnapprovedApplication.this,items);
                            recyclerView.setAdapter(unapproved_adapter);

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
