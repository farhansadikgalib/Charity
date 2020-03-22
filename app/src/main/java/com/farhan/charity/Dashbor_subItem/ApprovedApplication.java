package com.farhan.charity.Dashbor_subItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;
import com.farhan.charity.SubItem_Adapter.ApplicationApproved_Adapter;
import com.farhan.charity.SubItem_Adapter.ApplicationRecent_Adapter;

import java.util.ArrayList;
import java.util.List;

public class ApprovedApplication extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<ItemModel> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved_application);
        items = new ArrayList<>();
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ApprovedApplication.this);
        recyclerView = findViewById(R.id.recyclerView_approved);
        recyclerView.setLayoutManager(linearLayoutManager);
        ApplicationApproved_Adapter adapter = new ApplicationApproved_Adapter(ApprovedApplication.this, items);
        recyclerView.setAdapter(adapter);
    }
    public void getData(){
//
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
//

    }

    public void backToPrevious(View view) {
        super.onBackPressed();
    }
}