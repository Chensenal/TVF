package mefragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.master.tvf.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import base.BaseFragment;
import mefragment.activity.homepageactivity.HomePage;
import mefragment.activity.localmusicactivity.LocalMusic;
import mefragment.activity.loginactivity.LoginActivity;
import mefragment.activity.mycollectactivity.MyCollect;
import mefragment.bean.SongList;
import mefragment.meadapter.MeAdapter;
import utilsbean.CircleImageTransformation;
import utilsbean.RequestCode;
import utilsbean.ResultCode;
import utilsbean.User;


/**
 * Created by master on 2019/7/27.
 */

public class MeFragment extends BaseFragment implements View.OnClickListener{
    View rootView;
    ListView me_lv;
    ImageView iv_touxiang;
    ImageView iv_local_music;
    ImageView iv_my_collect;
    TextView tv_name;
    static  User user = new User();
   static String username;
    static String imagepath;
    private ArrayList<SongList>songLists;
    public static Handler handler = new Handler(){

        public void handleMessage(android.os.Message msg) {
            //获取我们携带的数据
            Bundle data = msg.getData();
            if(data!=null){
                username = data.getString("username");
                imagepath = data.getString("imagepath");
                if(imagepath!=null&&username!=null){
                    user.setHeadimagepath(imagepath);
                    user.setUsername(username);
                }else{
                    Log.e("hsdhs","dsjdsid");
                }

            }
        };
    };
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.me_layout, null);
        }

//        songLists = new ArrayList<>();
//        songLists.add(new SongList("歌1",1,2));
        tv_name = (TextView)rootView.findViewById(R.id.tv_name);
        iv_touxiang  = (ImageView)rootView.findViewById(R.id.iv_touxiang);
        iv_local_music = (ImageView)rootView.findViewById(R.id.iv_local_music);
        me_lv = (ListView) rootView.findViewById(R.id.me_lv);
        iv_my_collect = (ImageView)rootView.findViewById(R.id.iv_my_collect);




        iv_touxiang.setOnClickListener(this);
        iv_local_music.setOnClickListener(this);
        iv_my_collect.setOnClickListener(this);


        if(user.getHeadimagepath()!=null&&user.getUsername()!=null){
            tv_name.setText(username);
            Picasso.with(mContext)
                    .load(imagepath)
                    .transform(new CircleImageTransformation())
                    .into(iv_touxiang);
        }

        me_lv.setAdapter(new MeAdapter(mContext, songLists));
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            switch (requestCode){
                case 2 :{
                    if(resultCode==100){
                        String username = data.getStringExtra("username");
                        String imagepath = data.getStringExtra("imagepath");
                        user.setHeadimagepath(imagepath);
                        user.setUsername(username);
                        tv_name.setText(username);
                        Picasso.with(mContext)
                                .load(imagepath)
                                .transform(new CircleImageTransformation())
                                .into(iv_touxiang);
                    }
                    break;

                }
                case 7:{
                    if(resultCode==102){
                        Log.e("注册后的用户名",data.getStringExtra("username"));
                        Log.e("注册后的图像地址",data.getStringExtra("imagename"));
                    }
                    break;
                }
            }
        }else{
            Log.e("sadbuadb","data为null");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_touxiang:{
                if(user.getHeadimagepath()!=null&&user.getUsername()!=null){
                    Intent intent = new Intent();
                    intent.putExtra("username",user.getUsername());
                    intent.putExtra("imagepath",user.getHeadimagepath());
                    getActivity().setResult(ResultCode.RESULT_HOMEPAGE_CODE,intent);
                    intent.setClass(mContext, HomePage.class);
                    startActivityForResult(intent, RequestCode.REQUEST_CODE_HOMEPAGE);
                }else{
                    Intent intent =  new Intent();
                    intent.setClass(mContext,LoginActivity.class);
                    startActivityForResult(intent,RequestCode.REQUEST_CODE_LOGIN);
                }

                break;
            }
            case R.id.iv_local_music:{
                Intent intent = new Intent();
                intent.setClass(mContext, LocalMusic.class);
               startActivityForResult(intent,RequestCode.REQUEST_CODE_LOCAL_MUSIC);
                break;
            }
            case R.id.iv_my_collect:{
                Intent intent = new Intent();
                intent.setClass(mContext,MyCollect.class);
                startActivityForResult(intent,RequestCode.REQUEST_CODE_MYCOLLECT);
                break;
            }
        }
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

        Log.e("我的","我的Fragment主页面的内容");
    }
    public User getUserData(){


        return user;
    }

}
