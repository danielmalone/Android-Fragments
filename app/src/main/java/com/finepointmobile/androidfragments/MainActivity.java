package com.finepointmobile.androidfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by danielmalone on 7/29/17.
 */

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";

    ViewPager mPager;
    MainAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new MainAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
    }

    public static class MainAdapter extends FragmentPagerAdapter {

        public MainAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ArrayListFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 10;
        }
    }

    public static class ArrayListFragment extends ListFragment {

        int mNum;

        static ArrayListFragment newInstance(int number) {
            ArrayListFragment f = new ArrayListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("num", number);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            View view = inflater.inflate(R.layout.fragment_pager_list, container, false);
//            TextView name = (TextView) view.findViewById(R.id.name);
//            name.setText("Here! " + mNum);
            return view;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1));
        }
    }
}
