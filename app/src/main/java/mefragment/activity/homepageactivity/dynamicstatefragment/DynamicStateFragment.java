package mefragment.activity.homepageactivity.dynamicstatefragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.homepageactivity.dynamicstatefragment.dynamicstateadapter.DynamicStateAdapter;

/**
 * Created by master on 2019/8/5.
 */

public class DynamicStateFragment extends BaseFragment {
    View rootView;
    RecyclerView dynamicstate_recyclerview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.dynamicstate_layout, null);
        }
        dynamicstate_recyclerview = (RecyclerView) rootView.findViewById(R.id.dynamicstate_recyclerview);
        dynamicstate_recyclerview.setAdapter(new DynamicStateAdapter(mContext));
        dynamicstate_recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
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
        Log.e("动态","动态Fragment的内容");
    }
}
