package com.farhan.charity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farhan.charity.Adapter.Unapproved_Adapter;
import com.farhan.charity.Model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class Unapproved_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<ItemModel> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unapproved);


        items = new ArrayList<>();
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Unapproved_Activity.this);
        recyclerView = findViewById(R.id.recyclerView_unapproved);
        recyclerView.setLayoutManager(linearLayoutManager);
        Unapproved_Adapter adapter = new Unapproved_Adapter(Unapproved_Activity.this, items);
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
