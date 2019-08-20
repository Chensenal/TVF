package mefragment.activity.homepageactivity.homepageadapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import java.util.ArrayList;

import base.BaseFragment;
import mefragment.activity.homepageactivity.datafragment.DataFragment;
import mefragment.activity.homepageactivity.dynamicstatefragment.DynamicStateFragment;
import mefragment.activity.homepageactivity.musicfragment.MusicFragment;
import mefragment.activity.homepageactivity.supermenfragment.SuperMenFragment;

/**
 * Created by master on 2019/8/5.
 */

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.AdapterViewHolder> implements View.OnClickListener{

    private String username;
    private String imagepath;
    private Context mcontext;
    private FragmentActivity activity;

@Override
public HomePageAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext,R.layout.homepage_item,null);
        return new  HomePageAdapter.AdapterViewHolder(itemView);
        }

class AdapterViewHolder extends RecyclerView.ViewHolder {
    private ImageView homepage_iv_left;
    private TextView id_settings;
    private TextView home_page_exit;
    private ImageView homepage_iv_me;
    private TextView homepage_username;
    private TextView id_kugou;
    private ImageView homepage_iv_quickmark;
    private ImageView homepage_iv_editdata;
    private TextView homepage_tv_attention;
    private TextView homepage_tv_fans;
    private  TextView homepage_tv_visitor;
    private ImageView homepage_iv_add_btn;
    private TabLayout homepage_tablayout;
    private ViewPager homepage_viewpager;
    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> titles;



    public AdapterViewHolder(View itemView) {
        super(itemView);
        homepage_iv_left = (ImageView) itemView.findViewById(R.id.homepage_iv_left);
        id_settings = (TextView) itemView.findViewById(R.id.id_settings);
        home_page_exit = (TextView)itemView.findViewById(R.id.home_page_exit);
        homepage_iv_me = (ImageView)itemView.findViewById(R.id.homepage_iv_me);
        homepage_username = (TextView)itemView.findViewById(R.id.homepage_username);
        id_kugou = (TextView)itemView.findViewById(R.id.id_kugou);
        homepage_iv_quickmark = (ImageView)itemView.findViewById(R.id.homepage_iv_quickmark);
        homepage_iv_editdata = (ImageView)itemView.findViewById(R.id.homepage_iv_editdata);
        homepage_tv_attention = (TextView)itemView.findViewById(R.id.homepage_tv_attention);
        homepage_tv_fans  = (TextView)itemView.findViewById(R.id.homepage_tv_fans);
        homepage_tv_visitor  = (TextView)itemView.findViewById(R.id.homepage_tv_visitor);
        homepage_iv_add_btn = (ImageView)itemView.findViewById(R.id.homepage_iv_add_btn);
        homepage_tablayout = (TabLayout)itemView.findViewById(R.id.homepage_tablayout);
        homepage_viewpager = (ViewPager)itemView.findViewById(R.id.homepage_viewpager);
    }

}

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_settings:{

            }
        }
    }

    public HomePageAdapter(Context mcontext, FragmentActivity activity,String username,String imagepath) {
        this.mcontext = mcontext;
        this.activity = activity;
        this.username = username;
        this.imagepath = imagepath;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */
    @Override
    public void onBindViewHolder(HomePageAdapter.AdapterViewHolder holder, int position) {
            holder.homepage_iv_left.setImageResource(R.drawable.left);
            holder.id_settings.setText("账号和隐私");
            holder.home_page_exit.setText("退出");
            holder.homepage_iv_me.setImageResource(R.drawable.my_user_default);
            holder.homepage_username.setText("用户名");
            holder.id_kugou.setText("酷狗ID:"+"249383983");
            holder.homepage_iv_quickmark.setImageResource(R.drawable.left);
            holder.homepage_iv_editdata.setImageResource(R.drawable.left);
            holder.homepage_tv_attention.setText("关注");
            holder.homepage_tv_fans.setText("粉丝");
            holder.homepage_tv_visitor.setText("访客");
            holder.homepage_iv_add_btn.setImageResource(R.drawable.add_btn);
            initFragment(holder);
            initTitles(holder);
            inintViewPager(holder);



    }
    private void initTitles(HomePageAdapter.AdapterViewHolder holder){
        holder.titles = new ArrayList<>();
        holder.titles.add("动态");
        holder.titles.add("音乐");
        holder.titles.add("资料");
        holder.titles.add("超人");
    }
    private void initFragment(HomePageAdapter.AdapterViewHolder holder){

        holder.fragments = new ArrayList<>();
        holder.fragments.add(new DynamicStateFragment());
        holder.fragments.add(new MusicFragment());
        holder.fragments.add(new DataFragment());
        holder.fragments.add(new SuperMenFragment());
    }
    private void inintViewPager(final HomePageAdapter.AdapterViewHolder holder) {

        holder.homepage_viewpager.setAdapter(new FragmentStatePagerAdapter(activity.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return holder.fragments.get(position);
            }

            @Override
            public int getCount() {
                return holder.fragments.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return holder.titles.get(position);
            }

        });
        holder.homepage_tablayout.setupWithViewPager(holder.homepage_viewpager);
        holder.homepage_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return 1;
    }

}
