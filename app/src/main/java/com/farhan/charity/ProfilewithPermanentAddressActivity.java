package com.farhan.charity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ProfilewithPermanentAddressActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_with_permanent_address);



//        tabLayout= findViewById(R.id.tabLayout1);
//        viewPager= findViewById(R.id.viewPager);
        //
        //        i1= findViewById(R.id.item1);
//        i2= findViewById(R.id.item2);
//        i3= findViewById(R.id.item3);




        tabLayout.addTab(tabLayout.newTab().setText("cadadcac"));
        tabLayout.addTab(tabLayout.newTab().setText("asds"));
//        tabLayout.addTab(tabLayout.newTab().setText("asd"));
////        tabLayout.setTabTextColors(
//                getResources().getColor(R.color.colorPrimary),
//                getResources().getColor(R.color.colorAccent)
//        );

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


}

