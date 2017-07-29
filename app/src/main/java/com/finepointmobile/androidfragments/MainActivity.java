package com.finepointmobile.androidfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by danielmalone on 7/29/17.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    FloatingActionButton mFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFab = (FloatingActionButton) findViewById(R.id.fab);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: here");
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_main, new FragmentAbout(), "fragment_about");
                ft.commit();

                FragmentAbout fragmentAbout = (FragmentAbout) getSupportFragmentManager().findFragmentByTag("fragment_about");
                Log.d(TAG, "onClick: fragment: " + fragmentAbout);
            }
        });
    }
}
