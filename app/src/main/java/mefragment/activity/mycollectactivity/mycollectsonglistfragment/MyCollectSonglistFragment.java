package mefragment.activity.mycollectactivity.mycollectsonglistfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.mycollectactivity.mycollectsonglistfragment.mycollectsonglistadapter.MyCollectSonglistAdapter;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectSonglistFragment extends BaseFragment{
    View rootView;
    RecyclerView mycollectsonglist_recyclerview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.mycollectsonglist_layout, null);
        }
        mycollectsonglist_recyclerview = (RecyclerView)rootView.findViewById(R.id.mycollectsonglist_recyclerview);
        mycollectsonglist_recyclerview.setAdapter(new MyCollectSonglistAdapter(mContext));
        mycollectsonglist_recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
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
    }
}
