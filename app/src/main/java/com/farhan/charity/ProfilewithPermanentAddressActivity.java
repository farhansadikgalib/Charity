package com.farhan.charity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.farhan.charity.Adapter.MyAdapter;
import com.google.android.material.tabs.TabLayout;

public class ProfilewithPermanentAddressActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_with_permanent_address);



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

    public void backToAllApplication(View view){

        super.onBackPressed();
    }


}

