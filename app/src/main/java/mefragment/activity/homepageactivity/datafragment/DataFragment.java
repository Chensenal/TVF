package mefragment.activity.homepageactivity.datafragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.homepageactivity.datafragment.dataadapter.DataAdapter;

/**
 * Created by master on 2019/8/5.
 */

public class DataFragment extends BaseFragment {
    View rootView;
    RecyclerView data_recyclerview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.data_layout, null);
        }
        data_recyclerview = (RecyclerView) rootView.findViewById(R.id.data_recyclerview);
        data_recyclerview.setAdapter(new DataAdapter(mContext,getActivity()));
        data_recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
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
        Log.e("资料","资料Fragment的内容");
    }
}
