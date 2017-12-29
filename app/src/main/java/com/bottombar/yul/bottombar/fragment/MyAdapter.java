package com.bottombar.yul.bottombar.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Name: MyAdapter
 * Author: yul
 * Describe: //TODO
 * Date: 2017-12-28 17:48
 **/

public class MyAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public MyAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

}
