package com.finepointmobile.androidfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by danielmalone on 7/29/17.
 */

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mFab;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFab = (FloatingActionButton) findViewById(R.id.fab);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, new MainFragment(), "original_fragment");
        fragmentTransaction.commit();

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                FragmentTransaction newFragment = getSupportFragmentManager().beginTransaction();
                newFragment.replace(R.id.fragment_main, new FragmentContact(), "contact_fragment");
                newFragment.commit();
            }
        });
    }
}
