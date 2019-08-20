package searchactivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.tvf.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import interfaceutils.FilterListener;
import interfaceutils.Iservice;
import mainutils.MyStringCallBack;
import mefragment.activity.loginactivity.LoginActivity;
import mefragment.activity.mycollectactivity.MyCollect;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import searchactivity.searchadapter.SearchAdapter;
import serviceutils.MusicService;
import utilsbean.Requestnews;
import utilsbean.ResultCode;
import utilsbean.Song;
import utilsbean.UrlPath;
import utilsbean.User;
import utilsbean.UserInfoUtils;

/**
 * Created by master on 2019/8/13.
 */

public class SearchActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener {
    @Bind(R.id.search_et_music)
    EditText search_et_music;
    @Bind(R.id.search_tv_music)
    TextView search_tv_music;
    @Bind(R.id.music_lv)
   ListView music_lv;
    @Bind(R.id.seekBar)
    SeekBar seekBar;
    @Bind(R.id.previous)
    ImageButton previous;
    @Bind(R.id.btn_pause)
    ImageButton btn_pause;
    @Bind(R.id.next)
    ImageButton next;
    private boolean flag = true;
    private static Song song;
    private String musicname;
    private Iservice iservice; //这个是我们定义的中间人对象
    private MyConn conn;
    private int isStop = 1;
    private PopupWindow pw;
    private View pwView;
    private static ArrayList<String> list;
    private static ArrayList<Song> songs;
    private static User user;
    private static SearchAdapter adapter = null;
    public static Handler handler = new Handler(){

        public void handleMessage(android.os.Message msg) {
            switch (msg.what){
                case Requestnews.WHAT_REQUEST_SUCCESS:{

                    Log.e("listsdsds",list.size()+"");
                    break;
                }default:{
                    //获取我们携带的数据
                    Bundle data = msg.getData();
                    //获取歌曲的总时长 和 当前进度
                    int duration = data.getInt("duration");
                    int currentPosition = data.getInt("currentPosition");

                    //设置seekbar 的进度
                    sbar.setMax(duration);
                    sbar.setProgress(currentPosition);
                    break;
                }
            }
        };
    };
    private static SeekBar sbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        ButterKnife.bind(this);
        song = new Song();
        //混合方式开启服务
        //[1] 先调用startservice 目的是可以保证服务在后台长期运行
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        //[2]调用bindservice 目的为了获取我们定义的中间人对象  就可以间接的调用服务里面的方法了
        conn = new MyConn();
        bindService(intent, conn, BIND_AUTO_CREATE);

        //[3]找到seekbar   设置进度
        sbar = (SeekBar) findViewById(R.id.seekBar);

        //[4]给seekbar设置监听事件
        sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //当拖动停止的时候调用
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                iservice.callSeekTo(seekBar.getProgress());

            }

            //当开始拖动
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            //当进度改变
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

            }
        });
          //音乐列表


        list = new ArrayList<String>();
        user = new User();
        search_tv_music.setOnClickListener(this);

        adapter = new SearchAdapter(list, this, new FilterListener() {
            @Override
            public void getFilterData(List<String> list) {
                setItemClick(list);

            }
        });
        music_lv.setAdapter(adapter);
        music_lv.setOnItemLongClickListener(this);
        btn_pause.setOnClickListener(this);
        setListeners();
    }

    protected void setItemClick(final List<String> filter_lists) {
        music_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                musicname = list.get(position);
                iservice.callPlayMusic(musicname);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        musicname = songs.get(i).getMusicname();
        if(pw==null) {
            pwView = View.inflate(SearchActivity.this, R.layout.pw_layout, null);
            pw = new PopupWindow(pwView, view.getWidth() - 40, view.getHeight());
            pw.setBackgroundDrawable(new BitmapDrawable());
            pwView.findViewById(R.id.ll_pw_download).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.ll_pw_download: {
                            Map<String, String> maps = UserInfoUtils.readInfo();
                            if (maps != null) {
                                //把username 和 password 取出来
                                String username = maps.get("username");
                                String password = maps.get("password");
                                user.setUsername(username);
                                user.setPassword(password);
                                song.setMusicname(musicname);
                                download();
                            } else {
                                Toast.makeText(SearchActivity.this, "请你登录在进行下载", Toast.LENGTH_SHORT).show();
                            }
                            pw.dismiss();
                            break;
                        }
                    }


                }
            });

            pwView.findViewById(R.id.ll_pw_collect).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.ll_pw_collect: {
                            Map<String, String> maps = UserInfoUtils.readInfo();
                            if (maps != null) {
                                //把username 和 password 取出来
                                String username = maps.get("username");
                                String password = maps.get("password");
                                user.setUsername(username);
                                user.setPassword(password);
                                song.setMusicname(musicname);
                                collect(user, song);
                            } else {
                                Toast.makeText(SearchActivity.this, "请你登录在进行收藏", Toast.LENGTH_SHORT).show();
                            }
                            pw.dismiss();
                            break;
                        }

                    }
                }
            });
        }
        if(pw.isShowing()) {
            pw.dismiss();
        }

        pw.showAsDropDown(view, 40, -view.getHeight());
        ScaleAnimation animation = new ScaleAnimation(0, 1, 0, 1);
        animation.setDuration(1000);
        pwView.startAnimation(animation);
        adapter.notifyDataSetChanged();
        return true;
    }

    private void download(){
        String url = UrlPath.DOWNLOAD+song.getMusicname()+".mp3";

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(),song.getMusicname()+ ".mp3")//
                {

                    @Override
                    public void onBefore(Request request, int id)
                    {
                    }

                    @Override
                    public void inProgress(float progress, long total, int id)
                    {
//                        mProgressBar.setProgress((int) (100 * progress));
                        Log.e("inProgress", "inProgress :" + (int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id)
                    {
                        Log.e("onError", "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id)
                    {
                        Log.e("onResponse", "onResponse :" + file.getAbsolutePath());

                    }
                });


    }




    private void collect(User user,Song song){
        String url = UrlPath.COLLECTMUSIC;
        OkHttpUtils
                .post()
                .url(url)
                .addParams("song",new Gson().toJson(song))
                .addParams("user",new Gson().toJson(user))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(response.equals("收藏失败")||response.equals("该音乐以被收藏")){
                            Toast.makeText(SearchActivity.this,"抱歉服务器繁忙或者你的音乐已被收藏",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SearchActivity.this,"收藏成功",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    private void setListeners() {
        // 没有进行搜索的时候，也要添加对listView的item单击监听
        setItemClick(list);

        /**
         * 对编辑框添加文本改变监听，搜索的具体功能在这里实现
         * 很简单，文本该变的时候进行搜索。关键方法是重写的onTextChanged（）方法。
         */
        search_et_music.addTextChangedListener(new TextWatcher() {

            /**
             *
             * 编辑框内容改变的时候会执行该方法
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // 如果adapter不为空的话就根据编辑框中的内容来过滤数据
                if(adapter != null){
                    adapter.getFilter().filter(s);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_tv_music:{
                musicname = search_et_music.getText().toString().trim();
                if (TextUtils.isEmpty(musicname)) {
                    Toast.makeText(SearchActivity.this, "查找信息不能为空", Toast.LENGTH_LONG).show();
                } else {
                    song.setMusicname(musicname);
                    getGsonData(song);
                }
                break;
            }
            case R.id.btn_pause:{
                btn_pauseonclick();
                break;
            }

        }
    }
    public void  getGsonData(final Song song){
        String url = UrlPath.SEARCHMUISC;
        OkHttpUtils
                .post()
                .url(url)
                .addParams("song",new Gson().toJson(song))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(response.equals("查找失败")){
                            Toast.makeText(SearchActivity.this,"没有该歌曲",Toast.LENGTH_SHORT).show();
                        }else{
                            songs = new Gson().fromJson(response,new TypeToken<ArrayList<Song>>(){}.getType());
                            for(int i = 0;i < songs.size();i++){
                                list.add(songs.get(i).getMusicname());

                            }
                            SearchActivity.handler.sendEmptyMessage(Requestnews.WHAT_REQUEST_SUCCESS);
                        }

                    }
                });

    }

    private void Isstop(){
        switch (isStop){
            case 1:{
                btn_pause.setImageResource(android.R.drawable.ic_media_play);
                isStop = iservice.callPlayMusic(musicname);
                System.out.println("开始播放播放"+isStop);
                break;
            }case 2:{
                btn_pause.setImageResource(android.R.drawable.ic_media_play);
                isStop = iservice.callRePlayMusic();
                System.out.println("继续播放播放"+isStop);
                break;
            }case 3:{
                btn_pause.setImageResource(android.R.drawable.ic_media_pause);
                isStop = iservice.callPauseMusic();
                System.out.println("暂停播放"+isStop);
                break;
            }
        }

    }

    private void btn_pauseonclick(){
        if (musicname.isEmpty()){
            Toast.makeText(getApplicationContext(), "先选收歌曲先听听", Toast.LENGTH_SHORT).show();
        }else {
            Isstop();

        }
    }
    @Override
    protected void onDestroy() {
        //当Activity销毁的时候 解绑服务   目的是为了不报红色日志
        unbindService(conn);

        super.onDestroy();
    }



    // 点击按钮 暂停音乐
    public void click2(View v) {

        //调用暂停音乐的方法
        iservice.callPauseMusic();
    }

    // 点击按钮 继续播放音乐
    public void click3(View v) {

        //调用继续播放音乐的方法
        iservice.callRePlayMusic();
    }


    //监听服务的状态
    private class MyConn implements ServiceConnection {



        //当服务连接成功
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //获取我们定义的中间人对象

            iservice = (Iservice) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    }
}
