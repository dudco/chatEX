package com.example.dudco.chatex;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dudco.chatex.Fragment.ChatFragment;
import com.example.dudco.chatex.Fragment.ConfigFragment;
import com.example.dudco.chatex.Fragment.FriendFragment;

/**
 * Created by dudco on 2017. 2. 10..
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGER_NUM = 3;
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new FriendFragment();
            case 1 : return new ChatFragment();
            case 2 : return new ConfigFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGER_NUM;
    }
}
