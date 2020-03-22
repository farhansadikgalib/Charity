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

import com.farhan.charity.Adapter.Adapter_item1;
import com.farhan.charity.Model.AllZillaAdapter;
import com.farhan.charity.Model.AllitemsModel;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;

import java.util.ArrayList;
import java.util.List;

public class All_Application_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<ItemModel> items;
    //  ImageView BackId;

    TextView tv1,tv2;
    TextView rootTV_1;

    Spinner itemsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__application_);
        tv1 = findViewById(R.id.all_application_tv);
        tv2 = findViewById(R.id.without_upozilla_application_tv);
        rootTV_1 = findViewById(R.id.root_1_tv);
        itemsSpinner=findViewById(R.id.itemsSpinner);



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










        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootTV_1.setText("সকল আবেদন/");

                tv1.setBackgroundColor(Color.parseColor("#0B287B"));
                tv1.setTextColor(Color.parseColor("#ffffff"));
                tv2.setTextColor(Color.parseColor("#515151"));
                tv2.setBackgroundColor(Color.parseColor("#ffffff"));
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

            }
        });

        items = new ArrayList<>();
        getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(All_Application_Activity.this);
        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(linearLayoutManager);
        Adapter_item1 adapter = new Adapter_item1(All_Application_Activity.this, items);
        recyclerView.setAdapter(adapter);


    }






    public void getData(){


        items.add(new ItemModel(R.mipmap.ic_launcher,"Mridul","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Turjoy","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));
        items.add(new ItemModel(R.mipmap.ic_launcher,"Farhan","শিক্ষা আবেদন","৫০০০০০৯"));


    }


    public void onBackPressed(View view) {
        super.onBackPressed();
    }
}
