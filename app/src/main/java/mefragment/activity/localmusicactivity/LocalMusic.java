package mefragment.activity.localmusicactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import java.util.ArrayList;

import base.BaseFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import mefragment.activity.localmusicactivity.albunfragment.AlbunFragment;
import mefragment.activity.localmusicactivity.bookshelffragment.BookShelfFragment;
import mefragment.activity.localmusicactivity.folderfragment.FolderFragment;
import mefragment.activity.localmusicactivity.localsingerfragmnet.LocalSingerFragment;
import mefragment.activity.localmusicactivity.singlefragment.SingleFragment;
import watchfragment.singerfragment.SingerFragment;

/**
 * Created by master on 2019/8/7.
 */

public class LocalMusic extends FragmentActivity {
    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> titles;
    @Bind(R.id.local_music_tablayout)
    TabLayout local_music_tablayout;
    @Bind(R.id.local_music_viewpager)
    ViewPager local_music_viewpager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localmusic_layout);
        ButterKnife.bind(this);
        initFragment();
        initTitles();
        inintViewPager(LocalMusic.this);

    }
    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new SingleFragment());
        fragments.add(new LocalSingerFragment());
        fragments.add(new AlbunFragment());
        fragments.add(new BookShelfFragment());
        fragments.add(new FolderFragment());


    }
    private void initTitles(){
        titles = new ArrayList<>();
        titles.add("单曲");
        titles.add("歌手");
        titles.add("专辑");
        titles.add("书架");
        titles.add("文件夹");

    }
    private  void inintViewPager(FragmentActivity activity){

        local_music_viewpager.setAdapter(new FragmentStatePagerAdapter(activity.getSupportFragmentManager()) {
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
        local_music_tablayout.setupWithViewPager(local_music_viewpager);
        local_music_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
