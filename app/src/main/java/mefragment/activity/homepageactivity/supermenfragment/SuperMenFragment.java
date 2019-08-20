package mefragment.activity.homepageactivity.supermenfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.homepageactivity.supermenfragment.supermenadapter.SuperAdapter;

/**
 * Created by master on 2019/8/5.
 */

public class SuperMenFragment extends BaseFragment{

    View rootView;
    RecyclerView supermen_recyclerview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.supermen_layout, null);
        }
        supermen_recyclerview = (RecyclerView) rootView.findViewById(R.id.supermen_recyclerview);
        supermen_recyclerview.setAdapter(new SuperAdapter(mContext,getActivity()));
        supermen_recyclerview.setLayoutManager(new GridLayoutManager(mContext,3,GridLayoutManager.VERTICAL,false));
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
        Log.e("超人","超人Fragment的内容");
    }
}
