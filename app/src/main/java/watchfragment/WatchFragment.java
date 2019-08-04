package watchfragment;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import java.util.ArrayList;

import base.BaseFragment;
import listenfragment.ListenFragment;
import listenfragment.newsongfragment.NewSongFragment;
import mefragment.MeFragment;
import singfragment.SingFragment;
import watchfragment.attentionfragment.AttentionFragment;
import watchfragment.nearfragment.NearFragment;
import watchfragment.newshowfragment.NewShowFragment;
import watchfragment.recomendfragment.RecomendFragment;
import watchfragment.singerfragment.SingerFragment;
import watchfragment.specialfragment.SpecialFragment;

/**
 * Created by master on 2019/7/27.
 */

public class WatchFragment extends BaseFragment {
    private View rootView;
    private TabLayout watch_tabLayout;
    private ViewPager watch_viewpager;
    private FragmentActivity activity;
    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> titles;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.watch_layout, null);
        }
        watch_tabLayout = (TabLayout) rootView.findViewById(R.id.watch_tablayout);
        watch_viewpager = (ViewPager) rootView.findViewById(R.id.watch_viewpager);
        initFragment();
        initTitles();
        activity = getActivity();
        inintViewPager(activity);
        return rootView;
    }
    private void initTitles(){
        titles = new ArrayList<>();
        titles.add("关注");
        titles.add("推荐");
        titles.add("附近");
        titles.add("歌手");
        titles.add("新秀");
        titles.add("特色");
    }
    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new AttentionFragment());
        fragments.add(new RecomendFragment());
        fragments.add(new NearFragment());
        fragments.add(new SingerFragment());
        fragments.add(new NewShowFragment());
        fragments.add(new SpecialFragment());

    };
    private  void inintViewPager(FragmentActivity activity){

        watch_viewpager.setAdapter(new FragmentStatePagerAdapter(activity.getSupportFragmentManager()) {
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
        watch_tabLayout.setupWithViewPager(watch_viewpager);
        watch_tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootView != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }
    @Override
    public void initData() {
        super.initData();
        Log.e("看的","看的Fragment主页面的内容");
    }
}
