package com.farhan.charity.Dashboard_Items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.farhan.charity.Adapter.Adapter_item1;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;

import java.util.ArrayList;
import java.util.List;

public class Forward_Application_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<ItemModel> items;
    //  ImageView BackId;

    TextView tv1,tv2,tv3,tv4,tv5;
    TextView rootTV;
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

            }
        });







        items = new ArrayList<>();
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Forward_Application_Activity.this);
        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(linearLayoutManager);
        Adapter_item1 adapter = new Adapter_item1(Forward_Application_Activity.this, items);
        recyclerView.setAdapter(adapter);


    }

    public void getData(){

        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Sadik","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Galib","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));


    }





}
