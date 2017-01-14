package com.ersarizkidimitri.jazz2017;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ERD on 11/11/2016.
 */

public class MainPagerAdapter2 extends FragmentPagerAdapter {
    private ArrayList<RootFragment> fragments = new ArrayList<>();
    private RootFragment currentFragment;

    public MainPagerAdapter2(FragmentManager fm) {
        super(fm);

        fragments.clear();
        fragments.add(RootFragment.newInstance(0));
        fragments.add(RootFragment.newInstance(1));
        fragments.add(RootFragment.newInstance(2));
    }

    @Override
    public RootFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((RootFragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    public RootFragment getCurrentFragment() {
        return currentFragment;
    }

}
