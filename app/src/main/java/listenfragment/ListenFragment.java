package listenfragment;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.master.tvf.R;

import java.util.ArrayList;

import base.BaseFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import listenfragment.adapter.ListenGradViewAdapter;
import listenfragment.informationfragment.InformationFragment;
import listenfragment.livefragment.LiveFragment;
import listenfragment.newsongfragment.NewSongFragment;
import listenfragment.songlistfragment.SongListFragment;
import listenfragment.vediofragment.VedioFragment;


/**
 * Created by master on 2019/7/27.
 */

public class ListenFragment extends BaseFragment {
    private TabLayout listen_tablayout;
    private ViewPager listen_viewPager;
    private ArrayList<BaseFragment> fragments;
    private ArrayList<String> titles;
    private View rootView;
    FragmentActivity activity;
    private ViewPager banner_viewPager;
    private LinearLayout pointGroup;
    private TextView imageDesc;
    // 图片资源ID
    private final int[] imageIds = { R.drawable.a, R.drawable.b, R.drawable.c,
            R.drawable.d, R.drawable.e };
    //图片标题集合
    private final String[] imageDescriptions = {
            "巩俐不低俗，我就不能低俗",
            "扑树又回来啦！再唱经典老歌引万人大合唱",
            "揭秘北京电影如何升级",
            "乐视网TV版大派送",
            "热血屌丝的反杀"
    };

    private ArrayList<ImageView> imageList;
    private GridView listen_gridview;

    /**
     * 上一个页面的位置
     */
    protected int lastPosition;
    @Override
    public View initView() {
        Log.e("听的","听的Fragment主页面的视图");
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.listen_layout, null);

        }
       listen_tablayout = (TabLayout) rootView.findViewById(R.id.listen_tablayout);
        listen_viewPager = (ViewPager) rootView.findViewById(R.id.listen_viewpager);
        banner_viewPager = (ViewPager)rootView.findViewById(R.id.banner_viewpager);
        pointGroup = (LinearLayout) rootView.findViewById(R.id.point_group);
        imageDesc  = (TextView) rootView.findViewById(R.id.image_desc);
        listen_gridview = (GridView)rootView.findViewById(R.id.listen_gridview);


        imageDesc.setText(imageDescriptions[0]);

        initBanner();//广告
        listen_gridview.setAdapter(new ListenGradViewAdapter(mContext));//GridView的布局
        initFragment();
        initTitles();
        activity = getActivity();
        inintViewPager(activity);
        return rootView;
    }
    private  void initBanner(){
        imageList = new ArrayList<ImageView>();
        for (int i = 0; i <imageIds.length; i++) {


            //初始化图片资源
            ImageView image = new ImageView(mContext);
            image.setBackgroundResource(imageIds[i]);
            imageList.add(image);

            //添加指示点
            ImageView point =new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.rightMargin = 20;
            point.setLayoutParams(params);

            point.setBackgroundResource(R.drawable.point_bg);
            if(i==0){
                point.setEnabled(true);
            }else{
                point.setEnabled(false);
            }
            pointGroup.addView(point);
        }
        banner_viewPager.setAdapter(new MyPagerAdapter());
        banner_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                position = position%imageList.size();

                //设置文字描述内容
                imageDesc.setText(imageDescriptions[position]);

                //改变指示点的状态
                //把当前点enbale 为true
                pointGroup.getChildAt(position).setEnabled(true);
                //把上一个点设为false
                pointGroup.getChildAt(lastPosition).setEnabled(false);
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
         /*
		  * 自动循环：
		  * 1、定时器：Timer
		  * 2、开子线程 while  true 循环
		  * 3、ColckManager
		  * 4、 用handler 发送延时信息，实现循环
		  */
        isRunning = true;
        handler.sendEmptyMessageDelayed(0, 2000);
    }

    private boolean isRunning = false;

    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {

            //让viewPager 滑动到下一页
            banner_viewPager.setCurrentItem(banner_viewPager.getCurrentItem()+1);
            if(isRunning){
                handler.sendEmptyMessageDelayed(0, 2000);
            }
        };
    };
    public void onDestroy() {

        isRunning = false;
    };
    private class MyPagerAdapter extends PagerAdapter {

        @Override
        /**
         * 获得页面的总数
         */
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        /**
         * 获得相应位置上的view
         * container  view的容器，其实就是viewpager自身
         * position 	相应的位置
         */
        public Object instantiateItem(ViewGroup container, int position) {

            System.out.println("instantiateItem  ::"+position);

            // 给 container 添加一个view
            container.addView(imageList.get(position%imageList.size()));
            //返回一个和该view相对的object
            return imageList.get(position%imageList.size());
        }

        @Override
        /**
         * 判断 view和object的对应关系
         */
        public boolean isViewFromObject(View view, Object object) {
            if(view == object){
                return true;
            }else{
                return false;
            }
        }

        @Override
        /**
         * 销毁对应位置上的object
         */
        public void destroyItem(ViewGroup container, int position, Object object) {
            System.out.println("destroyItem  ::"+position);

            container.removeView((View) object);
            object = null;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootView != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }

    private void initTitles(){
        titles = new ArrayList<>();
        titles.add("新歌");
        titles.add("直播");
        titles.add("歌单");
        titles.add("咨讯");
        titles.add("视频");
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new NewSongFragment());
        fragments.add(new LiveFragment());
        fragments.add(new SongListFragment());
        fragments.add(new InformationFragment());
        fragments.add(new VedioFragment());
    }
    private void inintViewPager(FragmentActivity activity){
        listen_viewPager.setAdapter(new FragmentStatePagerAdapter(activity.getSupportFragmentManager()) {
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
        listen_tablayout.setupWithViewPager(listen_viewPager);
        listen_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
    @Override
    public void initData() {
        super.initData();
        Log.e("听的","听的Fragment主页面的内容");
    }
}
