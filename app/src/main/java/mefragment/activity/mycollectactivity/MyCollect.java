package mefragment.activity.mycollectactivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import java.util.ArrayList;

import base.BaseFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import mefragment.activity.mycollectactivity.mycollectbookshelffagment.MyCollectBookShelfFragment;
import mefragment.activity.mycollectactivity.mycollectsingerfragment.MyCollectSingerFragment;
import mefragment.activity.mycollectactivity.mycollectsinglefragment.MyCollectSingleFragment;
import mefragment.activity.mycollectactivity.mycollectsonglistfragment.MyCollectSonglistFragment;
import mefragment.activity.mycollectactivity.mycollectvediofragment.MyCollectVedioFragment;

/**
 * Created by master on 2019/8/8.
 */

public class MyCollect extends FragmentActivity {
    @Bind(R.id.mycollect_tablayout)
    TabLayout mycollect_tablayout;
    @Bind(R.id.mycollect_viewpager)
    ViewPager mycollect_viewpager;
    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> titles;
    private static Handler mHandler;
    public static void setHandler(Handler handler) {
        mHandler = handler;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycollect_layout);
        ButterKnife.bind(this);
        initFragment();
        initTitles();
        inintViewPager(MyCollect.this);
    }

    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new MyCollectSingleFragment());
        fragments.add(new MyCollectSonglistFragment());
        fragments.add(new MyCollectSingerFragment());
        fragments.add(new MyCollectVedioFragment());
        fragments.add(new MyCollectBookShelfFragment());

    }
    private void initTitles(){
       titles = new ArrayList<>();
        titles.add("单曲");
        titles.add("歌单");
        titles.add("歌手");
        titles.add("视频");
        titles.add("书架");
    }
    private  void inintViewPager(FragmentActivity activity){

        mycollect_viewpager.setAdapter(new FragmentStatePagerAdapter(activity.getSupportFragmentManager()) {
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
        mycollect_tablayout.setupWithViewPager(mycollect_viewpager);
        mycollect_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
