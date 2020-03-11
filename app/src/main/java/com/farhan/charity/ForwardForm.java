package com.farhan.charity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.farhan.charity.Model.AllZillaAdapter;

import java.util.ArrayList;
import java.util.List;

public class ForwardForm extends AppCompatActivity {
    Spinner zillaSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward_form);

        zillaSpinner=findViewById(R.id.zillaSpinner);

        List<AllZillaAdapter> allZillaAdapters=new ArrayList<>();
        AllZillaAdapter allZillaAdapter=new AllZillaAdapter("ঢাকা ");
        allZillaAdapters.add(allZillaAdapter);


        AllZillaAdapter allZillaAdapter2=new AllZillaAdapter("চট্টগ্রাম  ");
        allZillaAdapters.add(allZillaAdapter2);


        AllZillaAdapter allZillaAdapter3=new AllZillaAdapter("ফেনী  ");
        allZillaAdapters.add(allZillaAdapter3);


        AllZillaAdapter allZillaAdapter4=new AllZillaAdapter("কুমিল্লা  ");
        allZillaAdapters.add(allZillaAdapter4);


        AllZillaAdapter allZillaAdapter5=new AllZillaAdapter("গাজীপুর  ");
        allZillaAdapters.add(allZillaAdapter5);


        AllZillaAdapter allZillaAdapter6=new AllZillaAdapter("ময়মনশিংহ");
        allZillaAdapters.add(allZillaAdapter6);


        ArrayAdapter<AllZillaAdapter> adapter=new ArrayAdapter<AllZillaAdapter>(this,android.R.layout.simple_spinner_dropdown_item,
                allZillaAdapters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zillaSpinner.setAdapter(adapter);








    }

    public void backToApplicantsDetails(View view){
        super.onBackPressed();

    }
}