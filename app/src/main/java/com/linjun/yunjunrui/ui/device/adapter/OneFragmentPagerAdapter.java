package com.linjun.yunjunrui.ui.device.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by linjun on 2017/1/25.
 */

public class OneFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentsList;

    public OneFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public OneFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        return fragmentsList.get(arg0);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }


}
