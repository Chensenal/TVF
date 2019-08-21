package mefragment.activity.mycollectactivity.mycollectsinglefragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.master.tvf.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.extras.SoundPullEventListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import java.util.Map;

import base.BaseFragment;
import mefragment.activity.mycollectactivity.MyCollect;


import okhttp3.Call;

import utilsbean.Requestnews;
import utilsbean.Song;
import utilsbean.UrlPath;
import utilsbean.User;
import utilsbean.UserInfoUtils;

/**
 * Created by master on 2019/8/8.
 */

public class MyCollectSingleFragment extends BaseFragment{
    View rootView;

    private static int count =0;
    private static String countupdate;
    private static String []data;
    private static ArrayList<Song> songs;
    //一个可以下拉刷新的listView对象
    private PullToRefreshListView mycollect_single_lv;
    //普通的listview对象
    private ListView actualListView;
    //添加一个链表数组，来存放string数组，这样就可以动态增加string数组中的内容了
    private static LinkedList<String> mListItems;
    //给listview添加一个普通的适配器
    private ArrayAdapter<String> mAdapter;
    private static User user;
    public Handler mHandler = new Handler(){

        public void handleMessage(android.os.Message msg) {
            switch (msg.what){
                case Requestnews.WHAT_REQUEST_SUCCESS:{
                    if(data!=null&&data.length!=0){
                        mListItems = new LinkedList<String>();
                        mListItems.addAll(Arrays.asList(data));
                        mAdapter = new ArrayAdapter<>(mContext,
                                android.R.layout.simple_list_item_1, mListItems);
                        actualListView.setAdapter(mAdapter);
                    }else{
                        Toast.makeText(mContext,"没有该歌曲",Toast.LENGTH_SHORT).show();
                    }

                    break;
                }
                case Requestnews.WHAT_REQUEST_SUCCESS_UPDATE:{
                    if(mListItems!=null&&mListItems.size()!=0){
                        // 通知数据改变了
                        mAdapter.notifyDataSetChanged();
                        // 加载完成后停止刷新
                        mycollect_single_lv.onRefreshComplete();
                    }else{
                        mycollect_single_lv.onRefreshComplete();
                        Toast.makeText(mContext,"没有更多收藏歌曲",Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
            }
        };
    };
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.mycollectsingle_layout, null);
        }
        initPTRListView();
        initListView();
        return rootView;
    }

    /**
     * 设置下拉刷新的listview的动作
     */
    private void initPTRListView() {
        mycollect_single_lv = (PullToRefreshListView)rootView.findViewById(R.id.mycollect_single_lv);
        //设置拉动监听器
        mycollect_single_lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {

            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //设置下拉时显示的日期和时间
                String label = DateUtils.formatDateTime(mContext, System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // 更新显示的label
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                // 开始执行异步任务，传入适配器来进行数据改变
                new GetDataTask(mycollect_single_lv, mAdapter,mListItems).execute();
            }
        });

        // 添加滑动到底部的监听器
        mycollect_single_lv.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {

            @Override
            public void onLastItemVisible() {
                Toast.makeText(mContext, "已经到底了", Toast.LENGTH_SHORT).show();
            }
        });

        //mPullRefreshListView.isScrollingWhileRefreshingEnabled();//看刷新时是否允许滑动
        //在刷新时允许继续滑动
        mycollect_single_lv.setScrollingWhileRefreshingEnabled(true);
        //mPullRefreshListView.getMode();//得到模式
        //上下都可以刷新的模式。这里有两个选择：Mode.PULL_FROM_START，Mode.BOTH，PULL_FROM_END
        mycollect_single_lv.setMode(PullToRefreshBase.Mode.BOTH.PULL_FROM_END);

        /**
         * 设置反馈音效
         */
        SoundPullEventListener<ListView> soundListener = new SoundPullEventListener<ListView>(mContext);
        soundListener.addSoundEvent(PullToRefreshBase.State.PULL_TO_REFRESH, R.raw.pull_event);
        soundListener.addSoundEvent(PullToRefreshBase.State.RESET, R.raw.reset_sound);
        soundListener.addSoundEvent(PullToRefreshBase.State.REFRESHING, R.raw.refreshing_sound);
        mycollect_single_lv.setOnPullEventListener(soundListener);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
       MyCollect.setHandler(mHandler);

    }



    /**
     * 设置listview的适配器
     */
    private void initListView() {
        //通过getRefreshableView()来得到一个listview对象
        actualListView = mycollect_single_lv.getRefreshableView();

        Map<String, String> maps = UserInfoUtils.readInfo();
        user = new User();
        if (maps != null) {
            //把username 和 password 取出来
            String username = maps.get("username");
            String password = maps.get("password");
            user.setUsername(username);
            user.setPassword(password);
            collectecho(user);
        } else {
            Toast.makeText(mContext, "抱歉你没有登录暂时不能显示收藏的音乐", Toast.LENGTH_SHORT).show();
        }

    }
    private void collectecho(User user){
        String url = UrlPath.ECHOCOLLECTMUSIC;
        OkHttpUtils
                .post()
                .url(url)
                .addParams("user",new Gson().toJson(user))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(!response.equals("加载失败")){

                                songs = new Gson().fromJson(response,new TypeToken<ArrayList<Song>>(){}.getType());
                                data = new String[songs.size()];
                                for(int i = 0;i < songs.size();i++){
                                    data[i] = songs.get(i).getMusicname();
                                }
                                mHandler.sendEmptyMessage(Requestnews.WHAT_REQUEST_SUCCESS);
                        }else{
                            Toast.makeText(mContext,"没有该歌曲",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootView != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }

     class GetDataTask  extends AsyncTask<Void, Void, Void> {

        private PullToRefreshListView mPullRefreshListView;
        private ArrayAdapter<String> mAdapter;
        private LinkedList<String> mListItems;

        public GetDataTask(PullToRefreshListView listView,
                           ArrayAdapter<String> adapter,LinkedList<String> listItems) {
            // TODO 自动生成的构造函数存根
            this.mPullRefreshListView = listView;
            this.mAdapter = adapter;
            this.mListItems = listItems;

        }

        @Override
        protected Void doInBackground(Void... params) {
            //模拟请求
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO 自动生成的方法存根
            super.onPostExecute(result);
            //得到当前的模式
            PullToRefreshBase.Mode mode = mPullRefreshListView.getCurrentMode();
            count+=10;
            countupdate = count+"";
            collectechoupdate(user,countupdate);

        }

    }
    private void collectechoupdate(User user,String count){
        String url = UrlPath.ECHOCOLLECTMUSICUPDATE;
        Log.e("dssds",count);
        OkHttpUtils
                .post()
                .url(url)
                .addParams("user",new Gson().toJson(user))
                .addParams("count",count)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(!response.equals("加载失败")){
                            songs = new Gson().fromJson(response,new TypeToken<ArrayList<Song>>(){}.getType());
                            for(int i = 0;i < songs.size();i++){
                                mListItems.addLast(songs.get(i).getMusicname());
                            }
                            mHandler.sendEmptyMessage(Requestnews.WHAT_REQUEST_SUCCESS_UPDATE);
                        }else{
                            Toast.makeText(mContext,"没有更多收藏歌曲",Toast.LENGTH_SHORT).show();
                            mycollect_single_lv.onRefreshComplete();
                        }

                    }
                });

    }
}
