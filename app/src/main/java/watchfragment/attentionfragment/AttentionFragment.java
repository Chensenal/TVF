package watchfragment.attentionfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.master.tvf.R;

import base.BaseFragment;
import watchfragment.attentionfragment.adapter.AttentionAdapter;

/**
 * Created by master on 2019/8/2.
 */

public class AttentionFragment extends BaseFragment {
    View rootView;
    RecyclerView recyclerView;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.attention_layout, null);
        }
        recyclerView = (RecyclerView) rootView.findViewById(R.id.attention_recyclerview);
        recyclerView.setAdapter(new AttentionAdapter(mContext));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false));
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
