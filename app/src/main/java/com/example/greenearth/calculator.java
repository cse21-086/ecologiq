package com.example.greenearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class calculator extends AppCompatActivity {

    private ViewPager2 vp;
    private TabLayout TL;
    private Adaptorclass_for_tabs adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        vp = (ViewPager2) findViewById(R.id.pager2);
        TL = (TabLayout) findViewById(R.id.tabs);


        List<Fragment> frags = new ArrayList<>();
        frags.add(R.drawable.homepage, new Home());
        frags.add(R.drawable.newsanimation, new newsfeed());
        frags.add(R.drawable.shoppingbasket, new market());
        frags.add(R.drawable.baseline_monetization_on_24, new Donations());
        frags.add(R.drawable.settings, new settings());

    }
}