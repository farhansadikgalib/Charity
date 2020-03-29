package com.farhan.charity.Dashboard_Items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.Adapter.Adapter_item1;
import com.farhan.charity.Fragment.MainActivity;
import com.farhan.charity.Model.AllZillaAdapter;
import com.farhan.charity.Model.AllitemsModel;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class All_Application_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<ItemModel> items;
    //  ImageView BackId;

    TextView tv1,tv2;
    TextView rootTV_1;

    Spinner itemsSpinner;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__application_);
        tv1 = findViewById(R.id.all_application_tv);
        tv2 = findViewById(R.id.without_upozilla_application_tv);
        rootTV_1 = findViewById(R.id.root_1_tv);
        itemsSpinner=findViewById(R.id.itemsSpinner);


        mRequestQueue = Volley.newRequestQueue(this);

        ////


        //Below code is for spinner

        List<AllitemsModel> itemxx =new ArrayList<>();
        AllitemsModel allitemsModelAdapter =new AllitemsModel("সাম্প্রতিক আবেদন ");
        itemxx.add(allitemsModelAdapter);

        AllitemsModel allitemsModelAdapter2 =new AllitemsModel("অনুমোদিত আবেদন ");
        itemxx.add(allitemsModelAdapter2);
        AllitemsModel allitemsModelAdapter3 =new AllitemsModel("বিবেচনাধীন আবেদন ");
        itemxx.add(allitemsModelAdapter3);
        AllitemsModel allitemsModelAdapter4 =new AllitemsModel("অননুমোদিত আবেদন ");
        itemxx.add(allitemsModelAdapter4);
        AllitemsModel allitemsModelAdapter5 =new AllitemsModel("পুনরায় জমা আবেদন ");
        itemxx.add(allitemsModelAdapter5);




        ArrayAdapter<AllitemsModel> adapterx=new ArrayAdapter<AllitemsModel>(this,android.R.layout.simple_spinner_dropdown_item,itemxx);
        adapterx.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemsSpinner.setAdapter(adapterx);




        items = new ArrayList<>();
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(All_Application_Activity.this);
        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(linearLayoutManager);
        Adapter_item1 adapter = new Adapter_item1(All_Application_Activity.this, items);
        recyclerView.setAdapter(adapter);






        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootTV_1.setText("সকল আবেদন/");

                tv1.setBackgroundColor(Color.parseColor("#0B287B"));
                tv1.setTextColor(Color.parseColor("#ffffff"));
                tv2.setTextColor(Color.parseColor("#515151"));
                tv2.setBackgroundColor(Color.parseColor("#ffffff"));


                items = new ArrayList<>();
                getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(All_Application_Activity.this);
                recyclerView = findViewById(R.id.recyclerView1);
                recyclerView.setLayoutManager(linearLayoutManager);
                Adapter_item1 adapter = new Adapter_item1(All_Application_Activity.this, items);
                recyclerView.setAdapter(adapter);


            }
        });



        tv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                tv2.setBackgroundColor(Color.parseColor("#0B287B"));
                tv2.setTextColor(Color.parseColor("#ffffff"));
                rootTV_1.setText("উপজেলা বিহীন আবেদন/");
                tv1.setTextColor(Color.parseColor("#515151"));
                tv1.setBackgroundColor(Color.parseColor("#ffffff"));


                items = new ArrayList<>();
                getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(All_Application_Activity.this);
                recyclerView = findViewById(R.id.recyclerView1);
                recyclerView.setLayoutManager(linearLayoutManager);
                Adapter_item1 adapter = new Adapter_item1(All_Application_Activity.this, items);
                recyclerView.setAdapter(adapter);


            }
        });

    }






    public void getData(){




        String url = "http://charity.olivineltd.com/api/uno/application?admins_type=UNO&admins_track_id=SKW0V3qiOL20180808114529";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("applicationList");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject applicationList = jsonArray.getJSONObject(i);


                                //String profileImg = hit.getString("webformatURL");
                                String applicantName = applicationList.getString("users_name_bn");
                                String applicationAmount=applicationList.getString("application_amount");
                                String application_title_bn=applicationList.getString("application_title_bn");
                                String user_image =applicationList.getString("users_image");

                        //        int appliedfor = applicationList.getString();

                                items.add(new ItemModel(applicantName, applicationAmount, application_title_bn,user_image));
                            }

                            Adapter_item1 adapter_item1 = new Adapter_item1(All_Application_Activity.this,items);
                            recyclerView.setAdapter(adapter_item1);

                        }
                        catch (JSONException e) {
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


    public void onBackPressed(View view) {
        super.onBackPressed();
    }
}
