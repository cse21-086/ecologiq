package com.example.greenearth;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class adapter extends FragmentStateAdapter {

    public adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {


        if (position == 0) {

            return new main_interface();

        } else if (position == 1) {

            return new Donations();

        }else if (position == 2) {

            return new market();

        }else if (position == 3) {

            return new newsfeed();

        } else if (position == 4) {

            return new Announcements();

        } else return new main_interface();

    }


    @Override
    public int getItemCount() {
        return 5;
    }
}
