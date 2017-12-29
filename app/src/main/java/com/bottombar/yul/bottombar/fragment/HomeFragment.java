package com.bottombar.yul.bottombar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bottombar.yul.bottombar.R;

/**
 * Name: HomeFragment
 * Author: yul
 * Describe: //TODO
 * Date: 2017-12-28 17:33
 **/

public class HomeFragment extends Fragment {
    private String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frgament_home, container,false);

        TextView mText = (TextView)view.findViewById(R.id.txt);
        mText.setText(title);
        return view;

    }


    public static HomeFragment getInstens(String title) {
        HomeFragment mHomeFragment = new HomeFragment();
        mHomeFragment.title = title;
        return mHomeFragment;
    }
}
