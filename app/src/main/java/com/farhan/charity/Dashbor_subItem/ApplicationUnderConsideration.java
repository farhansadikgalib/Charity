package com.farhan.charity.Dashbor_subItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.farhan.charity.Adapter.Unapproved_Adapter;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;
import com.farhan.charity.SubItem_Adapter.ApplicationUnderConsideration_Adapter;

import java.util.ArrayList;
import java.util.List;

public class ApplicationUnderConsideration extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<ItemModel> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_under_consideration);
        items = new ArrayList<>();
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ApplicationUnderConsideration.this);
        recyclerView = findViewById(R.id.recyclerView_underConsideration);
        recyclerView.setLayoutManager(linearLayoutManager);
        ApplicationUnderConsideration_Adapter adapter = new ApplicationUnderConsideration_Adapter(ApplicationUnderConsideration.this, items);
        recyclerView.setAdapter(adapter);
    }
    public void getData(){

        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));


    }
}
