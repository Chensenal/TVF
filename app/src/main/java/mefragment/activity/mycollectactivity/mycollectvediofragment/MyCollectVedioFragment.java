package mefragment.activity.mycollectactivity.mycollectvediofragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.mycollectactivity.mycollectvediofragment.mycollectvedioadapter.MyCollectVedioAdapter;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectVedioFragment extends BaseFragment {
    View rootView;
    RecyclerView mycollectvedio_recyclerview;

    @Override
    public View initView() {
        if (rootView == null) {
            rootView = View.inflate(mContext, R.layout.mycollectvedio_layout, null);
        }
        mycollectvedio_recyclerview = (RecyclerView) rootView.findViewById(R.id.mycollectvedio_recyclerview);
        mycollectvedio_recyclerview.setAdapter(new MyCollectVedioAdapter(mContext));
        mycollectvedio_recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
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
