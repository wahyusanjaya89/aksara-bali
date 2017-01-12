package com.example.kopral.aksaratranslator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kopral on 18/09/16.
 */


public class FragmentBantuan extends Fragment {

    private static final int NUM_PAGES = 8;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View v = inflater.inflate(R.layout.fragment_bantuan, container, false);
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) v.findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getChildFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Bantuan");
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fr = new Fragment();

            switch (position) {
                case 0:
                    fr = new BantuanItem1();
                    break; // optional
                case 1:
                    fr = new BantuanItem2();
                    break; // optional
                case 2:
                    fr = new BantuanItem3();
                    break; // optional
                case 3:
                    fr = new BantuanItem4();
                    break; // optional
                case 4:
                    fr = new BantuanItem5();
                    break; // optional
                case 5:
                    fr = new BantuanItem6();
                    break; // optional
                case 6:
                    fr = new BantuanItem7();
                    break; // optional
                case 7:
                    fr = new BantuanItem8();
                    break; // optional

            }

            return fr;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}