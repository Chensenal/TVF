package mefragment.activity.mycollectactivity.mycollectsingerfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.mycollectactivity.mycollectsingerfragment.mycollectsingeradapter.MyCollectSingerAdapter;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectSingerFragment extends BaseFragment {
    View rootView;
    RecyclerView mycollectsinger_recyclerview;

    @Override
    public View initView() {
        if (rootView == null) {
            rootView = View.inflate(mContext, R.layout.mycollectsinger_layout, null);
        }
        mycollectsinger_recyclerview = (RecyclerView) rootView.findViewById(R.id.mycollectsinger_recyclerview);
        mycollectsinger_recyclerview.setAdapter(new MyCollectSingerAdapter(mContext));
        mycollectsinger_recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
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
