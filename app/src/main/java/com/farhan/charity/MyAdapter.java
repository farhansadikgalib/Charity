package com.farhan.charity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {


    private Context myContext;
    int totalTabs;

    private String[] tabTitles = new String[]{"স্থায়ী ঠিকানা", "বর্তমান ঠিকানা"};

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }


    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ParmanentAddressFragment parmanentAddressFragment = new ParmanentAddressFragment();
                return parmanentAddressFragment;
            case 1:
                PresentAddressFragment presentAddressFragment = new PresentAddressFragment();
                return presentAddressFragment;

            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
