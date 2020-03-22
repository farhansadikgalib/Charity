package com.farhan.charity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.Adapter.MyAdapter;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProfilewithPermanentAddressActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TextView users_nameTV,users_name_bnTV,users_emailTV,users_phoneTV,users_father_name_bnTV,users_mother_name_bnTV,users_genderTV,users_blood_groupTV,
            users_dobTV,users_nidTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_with_permanent_address);

        users_nameTV = findViewById(R.id.users_name_bn_BOLD_ID);
        users_name_bnTV = findViewById(R.id.users_nameID);
        users_emailTV = findViewById(R.id.users_emailID);
        users_phoneTV = findViewById(R.id.users_phoneID);
        users_father_name_bnTV = findViewById(R.id.users_father_name_bn_ID);
        users_mother_name_bnTV = findViewById(R.id.users_mother_name_bn_ID);
        users_genderTV = findViewById(R.id.users_gender_ID);
        users_blood_groupTV = findViewById(R.id.users_blood_group_ID);
        users_dobTV = findViewById(R.id.users_dob_ID);
        users_nidTV = findViewById(R.id.users_nid_ID);


        DeatailsParsex();







        tabLayout= findViewById(R.id.tabLayout1);
        viewPager= findViewById(R.id.viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void DeatailsParsex() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://charity.olivineltd.com/api/user/vfDDQMOL20180726203942", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //  Toast.makeText(getContext(), "hello" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String users_name = jsonObject.getString("users_name");
                    String users_name_bn = jsonObject.getString("users_name_bn");
                    String users_email = jsonObject.getString("users_email");
                    String users_phone = jsonObject.getString("users_phone");
                    String users_father_name_bn = jsonObject.getString("users_father_name_bn");
                    String users_mother_name_bn = jsonObject.getString("users_mother_name_bn");
                    String users_gender = jsonObject.getString("users_gender");
                    String users_blood_group = jsonObject.getString("users_blood_group");
                    String users_dob = jsonObject.getString("users_dob");
                    String users_nid = jsonObject.getString("users_nid");


                    // Toast.makeText(getContext(), ""+admins_type+" "+admins_track_id, Toast.LENGTH_SHORT).show();


                    users_nameTV.setText(users_name);
                    users_name_bnTV.setText(users_name_bn);
                    users_emailTV.setText(users_email);
                    users_phoneTV.setText(users_phone);
                    users_father_name_bnTV.setText(users_father_name_bn);
                    users_mother_name_bnTV.setText(users_mother_name_bn);
                    users_genderTV.setText(users_gender);
                    users_blood_groupTV.setText(users_blood_group);
                    users_dobTV.setText(users_dob);
                    users_nidTV.setText(users_nid);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error" , Toast.LENGTH_SHORT).show();
            }
        }) ;

        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }

    public void backToAllApplication(View view){

        super.onBackPressed();
    }


}

