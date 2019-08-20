package mefragment.activity.downloadmanageractivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import java.util.ArrayList;

import base.BaseFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by master on 2019/8/9.
 */

public class DownloadManagerActivity extends FragmentActivity {
    @Bind(R.id.downloadmanager_iv_left)
    ImageView downloadmanager_iv_left;
    @Bind(R.id.dowloadmanager_tv)
    TextView dowloadmanager_tv;
    @Bind(R.id.downloadmanager_tv_history)
    TextView downloadmanager_tv_history;
    @Bind(R.id.downloadmanager_tablayout)
    TabLayout downloadmanager_tablayout;
    @Bind(R.id.downloadmanager_viewpager)
    ViewPager downloadmanager_viewpager;
    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> titles;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloadmanager_layout);
        ButterKnife.bind(this);
        initFragment();
        initTitles();
        inintViewPager();
    }
    private void initFragment(){}
    private void initTitles(){}
    private void inintViewPager(){}
}
