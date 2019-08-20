package mefragment.activity.downloadmanageractivity.downloadmanagersinglefragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.homepageactivity.supermenfragment.supermenadapter.SuperAdapter;

/**
 * Created by master on 2019/8/9.
 */

public class DownLoadManagerSingleFragment  extends BaseFragment {

    View rootView;
    RecyclerView downloadmanagersingle_recyclerview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.downloadmanagersingle_layout, null);
        }
        downloadmanagersingle_recyclerview = (RecyclerView) rootView.findViewById(R.id.downloadmanagersingle_recyclerview);
        downloadmanagersingle_recyclerview.setAdapter(new SuperAdapter(mContext,getActivity()));
        downloadmanagersingle_recyclerview.setLayoutManager(new GridLayoutManager(mContext,3,GridLayoutManager.VERTICAL,false));
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
        Log.e("下载单曲","下载单曲Fragment的内容");
    }
}

