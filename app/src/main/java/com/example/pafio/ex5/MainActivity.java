package com.example.pafio.ex5;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ViewPagerAdapter viewPagerAdapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        Bundle args1 = new Bundle();
        args1.putString("textValue", "One");
        Bundle args2 = new Bundle();
        args2.putString("textValue", "Two");
        Bundle args3 = new Bundle();
        args3.putString("textValue", "Three");

        TabFragment instance1 = new TabFragment();
        instance1.setArguments(args1);
        TabFragment instance2 = new TabFragment();
        instance2.setArguments(args2);
        TabFragment instance3 = new TabFragment();
        instance3.setArguments(args3);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(instance1, "ONE");
        adapter.addFragment(instance2, "TWO");
        adapter.addFragment(instance3, "THREE");
        viewPager.setAdapter(adapter);
    }
}
