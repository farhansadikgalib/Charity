package com.farhan.charity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farhan.charity.Adapter.UnderConsideration_Adapter;
import com.farhan.charity.Model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class Under_consideration_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<ItemModel> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_consideration);


        items = new ArrayList<>();
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Under_consideration_Activity.this);
        recyclerView = findViewById(R.id.recyclerView_underConsideration);
        recyclerView.setLayoutManager(linearLayoutManager);
        UnderConsideration_Adapter adapter = new UnderConsideration_Adapter(Under_consideration_Activity.this, items);
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
