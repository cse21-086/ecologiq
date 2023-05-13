package com.example.greenearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

public class fragies extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager2 v2;
    private  adapter adr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragies);

        tl  = findViewById(R.id.tibys);
        v2  = findViewById(R.id.pager2);

        TabLayout.Tab tab_home = tl.newTab().setText("Home");
        TabLayout.Tab tab_donate = tl.newTab().setText("Donate");
        TabLayout.Tab tab_market = tl.newTab().setText("Market");
        TabLayout.Tab tab_newsfeed = tl.newTab().setText("Newsfeed");
        TabLayout.Tab tab_announcements = tl.newTab().setText("Announcements");

        tl.addTab(tab_home);
        tl.addTab(tab_donate);
        tl.addTab(tab_market);
        tl.addTab(tab_newsfeed);
        tl.addTab(tab_announcements);

        tab_home.setIcon(R.drawable.baseline_home_24);
        tab_donate.setIcon(R.drawable.baseline_monetization_on_24);
        tab_market.setIcon(R.drawable.baseline_shopping_cart_24);
        tab_newsfeed.setIcon(R.drawable.baseline_feed_24);
        tab_announcements.setIcon(R.drawable.baseline_announcement_24);

        FragmentManager frags = getSupportFragmentManager();
        adr = new adapter(frags, getLifecycle());
        v2.setAdapter(adr);

        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {



                Drawable icon = tab.getIcon();
                if (icon != null){

                    v2.setCurrentItem(tab.getPosition());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        v2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tl.selectTab(tl.getTabAt(position));
            }
        });

    }


}
