package watchfragment.newshowfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.master.tvf.R;

import base.BaseFragment;
import watchfragment.newshowfragment.adapter.NewShowAdapter;

/**
 * Created by master on 2019/8/2.
 */

public class NewShowFragment extends BaseFragment {
    View rootView;
   RecyclerView newshow_recyclerview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.newshow_layout, null);
        }
        newshow_recyclerview = (RecyclerView) rootView.findViewById(R.id.newshow_recycler);
        newshow_recyclerview.setAdapter(new NewShowAdapter(mContext));
        newshow_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false));
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
