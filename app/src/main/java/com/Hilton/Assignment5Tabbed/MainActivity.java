package com.Hilton.Assignment5Tabbed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.HiltonTabbed.Assignment5Tabbed.R;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tab_layout);
        viewPager2=findViewById(R.id.view_pager2);

        //Getting Fragment Manager
        FragmentManager fManager=getSupportFragmentManager();
        adapter=new FragmentAdapter(fManager, getLifecycle());
        viewPager2.setAdapter(adapter);

        //Creating three tabs
        tabLayout.addTab(tabLayout.newTab().setText("Registration"));
        tabLayout.addTab(tabLayout.newTab().setText("User Profile"));
        tabLayout.addTab(tabLayout.newTab().setText("All Users"));
        //OnTabListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            viewPager2.getAdapter().notifyDataSetChanged();
            
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }
}