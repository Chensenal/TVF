package com.example.master.tvf;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import base.BaseFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import listenfragment.ListenFragment;
import mefragment.MeFragment;
import searchactivity.SearchActivity;
import singfragment.SingFragment;
import watchfragment.WatchFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.search)
    ImageView search;
    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        search.setImageResource(R.drawable.search);
        search.setOnClickListener(this);
        initFragment();
        initTitles();
        inintViewPager();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search:{
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        }
    }

    private void initTitles(){
        titles = new ArrayList<>();
        titles.add("我");
        titles.add("听");
        titles.add("看");
        titles.add("唱");
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new MeFragment());
        fragments.add(new ListenFragment());
        fragments.add(new WatchFragment());
        fragments.add(new SingFragment());
    }
    private void inintViewPager(){
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }


        });
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

}
