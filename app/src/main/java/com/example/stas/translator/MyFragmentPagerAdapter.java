package com.example.stas.translator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Stas on 18.04.2017.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    static final int PAGE_COUNT = 2;

    Context context = null;

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    public MyFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
