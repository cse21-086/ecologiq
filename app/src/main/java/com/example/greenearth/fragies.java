package com.example.greenearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

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

        tl.addTab(tl.newTab().setIcon(R.drawable.baseline_home_24));
        tl.addTab(tl.newTab().setIcon(R.drawable.baseline_monetization_on_24));
        tl.addTab(tl.newTab().setIcon(R.drawable.baseline_shopping_cart_24));
        tl.addTab(tl.newTab().setIcon(R.drawable.baseline_feed_24));


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
