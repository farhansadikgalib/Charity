package com.farhan.charity.Dashboard_Items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import com.farhan.charity.Adapter.Adapter_item2;
import com.farhan.charity.Model.AllitemsModel;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Forward_Application_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<ItemModel> items;
    //  ImageView BackId;

    TextView tv1,tv2,tv3,tv4,tv5;
    TextView rootTV,rootTV_2;
    Spinner itemsSpinnerx;
    LinearLayoutManager linearLayoutManager;
    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward__application);

        tv1 = findViewById(R.id.all_tv);
        tv2 = findViewById(R.id.education_tv);
        tv3 = findViewById(R.id.calamities_tv);
        tv4 = findViewById(R.id.health_tv);
        tv5 = findViewById(R.id.autistic_tv);

        rootTV = findViewById(R.id.root_tv);
        rootTV_2 = findViewById(R.id.rootTV_2);

        itemsSpinnerx=findViewById(R.id.itemsSpinnerx);

        mRequestQueue = Volley.newRequestQueue(this);





        List<AllitemsModel> itemxx =new ArrayList<>();
        AllitemsModel allitemsModelAdapter =new AllitemsModel("সাম্প্রতিক আবেদন ");
        itemxx.add(allitemsModelAdapter);

        AllitemsModel allitemsModelAdapter2 =new AllitemsModel("অনুমোদিত আবেদন ");
        itemxx.add(allitemsModelAdapter2);
        AllitemsModel allitemsModelAdapter3 =new AllitemsModel("বিবেচনাধীন আবেদন ");
        itemxx.add(allitemsModelAdapter3);
        AllitemsModel allitemsModelAdapter4 =new AllitemsModel("অননুমদিত আবেদন ");
        itemxx.add(allitemsModelAdapter4);
        AllitemsModel allitemsModelAdapter5 =new AllitemsModel("পুনরায় জমা আবেদন ");
        itemxx.add(allitemsModelAdapter5);




        ArrayAdapter<AllitemsModel> adapterx=new ArrayAdapter<AllitemsModel>(this,android.R.layout.simple_spinner_dropdown_item,itemxx);
        adapterx.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemsSpinnerx.setAdapter(adapterx);



        itemsSpinnerx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        rootTV_2.setText("সাম্প্রতিক আবেদন");

                        items = new ArrayList<>();
                        getData();
                        linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                        recyclerView = findViewById(R.id.recyclerView1);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        Adapter_item1 adapter0 = new Adapter_item1(Forward_Application_Activity.this, items);
                        recyclerView.setAdapter(adapter0);

                        break;
                    case 1:
                        items = new ArrayList<>();
                        getData();
                        linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                        recyclerView = findViewById(R.id.recyclerView1);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        Adapter_item1 adapter1 = new Adapter_item1(Forward_Application_Activity.this, items);
                        recyclerView.setAdapter(adapter1);
                        break;
                    case 2:
                        rootTV_2.setText("বিবেচনাধীন আবেদন");
                        items = new ArrayList<>();
                        getData();
                         linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                        recyclerView = findViewById(R.id.recyclerView1);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        Adapter_item1 adapter2 = new Adapter_item1(Forward_Application_Activity.this, items);
                        recyclerView.setAdapter(adapter2);
                        break;

                    case 3:
                        items = new ArrayList<>();
                        getData();
                         linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                        recyclerView = findViewById(R.id.recyclerView1);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        Adapter_item1 adapter3 = new Adapter_item1(Forward_Application_Activity.this, items);
                        recyclerView.setAdapter(adapter3);
                        rootTV_2.setText("অননুমোদিত আবেদন");


                        break;

                    case 4:
                        items = new ArrayList<>();
                        getData();
                        linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                        recyclerView = findViewById(R.id.recyclerView1);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        Adapter_item1 adapter4 = new Adapter_item1(Forward_Application_Activity.this, items);
                        recyclerView.setAdapter(adapter4);

                        rootTV_2.setText("পুনরায় জমা আবেদন ");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootTV.setText("সকল /");

                tv1.setBackgroundColor(Color.parseColor("#0B287B"));
                tv1.setTextColor(Color.parseColor("#ffffff"));
                tv2.setTextColor(Color.parseColor("#515151"));
                tv2.setBackgroundColor(Color.parseColor("#ffffff"));

                tv3.setTextColor(Color.parseColor("#515151"));
                tv3.setBackgroundColor(Color.parseColor("#ffffff"));


                tv4.setTextColor(Color.parseColor("#515151"));
                tv4.setBackgroundColor(Color.parseColor("#ffffff"));


                tv5.setTextColor(Color.parseColor("#515151"));
                tv5.setBackgroundColor(Color.parseColor("#ffffff"));


                items = new ArrayList<>();
                getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                recyclerView = findViewById(R.id.recyclerView1);
                recyclerView.setLayoutManager(linearLayoutManager);
                Adapter_item2 adapter = new Adapter_item2(Forward_Application_Activity.this, items);
                recyclerView.setAdapter(adapter);




            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootTV.setText("শিক্ষা /");

                tv2.setBackgroundColor(Color.parseColor("#0B287B"));
                tv2.setTextColor(Color.parseColor("#ffffff"));
                tv1.setTextColor(Color.parseColor("#515151"));
                tv1.setBackgroundColor(Color.parseColor("#ffffff"));

                tv3.setTextColor(Color.parseColor("#515151"));
                tv3.setBackgroundColor(Color.parseColor("#ffffff"));


                tv4.setTextColor(Color.parseColor("#515151"));
                tv4.setBackgroundColor(Color.parseColor("#ffffff"));


                tv5.setTextColor(Color.parseColor("#515151"));
                tv5.setBackgroundColor(Color.parseColor("#ffffff"));




                items = new ArrayList<>();
                getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                recyclerView = findViewById(R.id.recyclerView1);
                recyclerView.setLayoutManager(linearLayoutManager);
                Adapter_item2 adapter = new Adapter_item2(Forward_Application_Activity.this, items);
                recyclerView.setAdapter(adapter);




            }
        });


        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootTV.setText("দূর্যোগ /");

                tv3.setBackgroundColor(Color.parseColor("#0B287B"));
                tv3.setTextColor(Color.parseColor("#ffffff"));
                tv1.setTextColor(Color.parseColor("#515151"));
                tv1.setBackgroundColor(Color.parseColor("#ffffff"));

                tv2.setTextColor(Color.parseColor("#515151"));
                tv2.setBackgroundColor(Color.parseColor("#ffffff"));


                tv4.setTextColor(Color.parseColor("#515151"));
                tv4.setBackgroundColor(Color.parseColor("#ffffff"));


                tv5.setTextColor(Color.parseColor("#515151"));
                tv5.setBackgroundColor(Color.parseColor("#ffffff"));



                items = new ArrayList<>();
                getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                recyclerView = findViewById(R.id.recyclerView1);
                recyclerView.setLayoutManager(linearLayoutManager);
                Adapter_item2 adapter = new Adapter_item2(Forward_Application_Activity.this, items);
                recyclerView.setAdapter(adapter);




            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootTV.setText("স্বাস্থ্য /");

                tv4.setBackgroundColor(Color.parseColor("#0B287B"));
                tv4.setTextColor(Color.parseColor("#ffffff"));
                tv1.setTextColor(Color.parseColor("#515151"));
                tv1.setBackgroundColor(Color.parseColor("#ffffff"));

                tv2.setTextColor(Color.parseColor("#515151"));
                tv2.setBackgroundColor(Color.parseColor("#ffffff"));


                tv3.setTextColor(Color.parseColor("#515151"));
                tv3.setBackgroundColor(Color.parseColor("#ffffff"));


                tv5.setTextColor(Color.parseColor("#515151"));
                tv5.setBackgroundColor(Color.parseColor("#ffffff"));


                items = new ArrayList<>();
                getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                recyclerView = findViewById(R.id.recyclerView1);
                recyclerView.setLayoutManager(linearLayoutManager);
                Adapter_item2 adapter = new Adapter_item2(Forward_Application_Activity.this, items);
                recyclerView.setAdapter(adapter);




            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootTV.setText("প্রতিবন্ধী /");

                tv5.setBackgroundColor(Color.parseColor("#0B287B"));
                tv5.setTextColor(Color.parseColor("#ffffff"));
                tv1.setTextColor(Color.parseColor("#515151"));
                tv1.setBackgroundColor(Color.parseColor("#ffffff"));

                tv2.setTextColor(Color.parseColor("#515151"));
                tv2.setBackgroundColor(Color.parseColor("#ffffff"));


                tv3.setTextColor(Color.parseColor("#515151"));
                tv3.setBackgroundColor(Color.parseColor("#ffffff"));


                tv4.setTextColor(Color.parseColor("#515151"));
                tv4.setBackgroundColor(Color.parseColor("#ffffff"));


                items = new ArrayList<>();
                getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
                recyclerView = findViewById(R.id.recyclerView1);
                recyclerView.setLayoutManager(linearLayoutManager);
                Adapter_item2 adapter = new Adapter_item2(Forward_Application_Activity.this, items);
                recyclerView.setAdapter(adapter);





            }
        });







        items = new ArrayList<>();
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(linearLayoutManager);
        Adapter_item2 adapter = new Adapter_item2(Forward_Application_Activity.this, items);
        recyclerView.setAdapter(adapter);


    }

    public void getData(){

//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Sadik","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Galib","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));

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
                                String application_id = applicationList.getString("application_id");
                                String application_Staus = applicationList.getString("application_status");
                                ItemModel itemModel = new ItemModel(applicantName, applicationAmount, application_title_bn, user_image);
                                ItemModel test = new ItemModel(applicantName, applicationAmount, application_title_bn, user_image,application_id,application_Staus);
                                items.add(test);
                            }

                            Adapter_item1 adapter_item1 = new Adapter_item1(Forward_Application_Activity.this,items);
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
