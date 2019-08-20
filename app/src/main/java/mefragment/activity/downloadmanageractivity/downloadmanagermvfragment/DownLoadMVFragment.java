package mefragment.activity.downloadmanageractivity.downloadmanagermvfragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.master.tvf.R;

import java.util.ArrayList;

import base.BaseFragment;
import mefragment.activity.homepageactivity.HomePage;
import mefragment.activity.localmusicactivity.LocalMusic;
import mefragment.activity.mycollectactivity.MyCollect;
import mefragment.bean.SongList;
import mefragment.meadapter.MeAdapter;

/**
 * Created by master on 2019/8/10.
 */

public class DownLoadMVFragment extends BaseFragment {

    View rootView;
    private ArrayList<SongList> songLists;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.downloadmanagermv_layout, null);
        }
        return rootView;
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
        Log.e("MV","MVFragment主页面的内容");
    }
}
