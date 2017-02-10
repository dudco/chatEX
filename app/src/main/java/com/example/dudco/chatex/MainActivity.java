package com.example.dudco.chatex;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private TabLayout main_tab;
    private ViewPager main_viewPager;
    private Toolbar main_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        main_toolbar.setTitleTextColor(Color.WHITE);
        main_toolbar.setTitle("친구");
        setSupportActionBar(main_toolbar);

        main_tab = (TabLayout) findViewById(R.id.main_tab);
        main_viewPager = (ViewPager) findViewById(R.id.main_viewpager);

        main_tab.setTabGravity(TabLayout.GRAVITY_FILL);
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_man_click).setTag("man"));
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_chat_nonclick).setTag("chat"));
        main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_config_nonclick).setTag("config"));

        main_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getTag().toString()){
                    case "man" : tab.setIcon(R.drawable.ic_man_click);
                        getSupportActionBar().setTitle("친구");
                        break;
                    case "chat" : tab.setIcon(R.drawable.ic_chat_click);
                        getSupportActionBar().setTitle("채팅");
                        break;
                    case "config" : tab.setIcon(R.drawable.ic_config_click);
                        getSupportActionBar().setTitle("설정");
                        break;
                }
                main_viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d("dudco", tab.getTag().toString());
                switch (tab.getTag().toString()){
                    case "man" : tab.setIcon(R.drawable.ic_man_nonclick); break;
                    case "chat" : tab.setIcon(R.drawable.ic_chat_nonclick); break;
                    case "config" : tab.setIcon(R.drawable.ic_config_nonclick); break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        main_viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));
        main_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(main_tab));
    }
}
