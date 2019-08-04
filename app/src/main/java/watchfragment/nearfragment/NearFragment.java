package watchfragment.nearfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.master.tvf.R;

import base.BaseFragment;
import watchfragment.nearfragment.adapter.NearAdapter;

/**
 * Created by master on 2019/8/2.
 */

public class NearFragment extends BaseFragment {
    View rootView;
    RecyclerView near_recyclerview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.near_layout, null);
        }
        near_recyclerview = (RecyclerView) rootView.findViewById(R.id.near_recycler);
        near_recyclerview.setAdapter(new NearAdapter(mContext));
        near_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false));
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
        Log.e("关注","关注Fragment的内容");
    }

}
