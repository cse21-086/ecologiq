package com.example.greenearth;

import static java.security.AccessController.getContext;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
//TODO adapter class allows objects with incompatible interfaces to work together by providing a common interface that both can use

public class Adaptorclass_for_tabs extends FragmentStateAdapter {

    private final List<Fragment> fragments;
    private final List<Integer> icons;

    public Adaptorclass_for_tabs(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments, List<Integer> icons) {
        super(fragmentActivity);
        this.fragments = fragments;
        this.icons = icons;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }


    public CharSequence getPageTitle(int position) {
        // Return null to display only the icon as the tab title
        return null;
    }



}
