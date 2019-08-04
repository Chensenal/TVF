package watchfragment.singerfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.master.tvf.R;

import base.BaseFragment;
import watchfragment.singerfragment.adapter.SingerAdapter;

/**
 * Created by master on 2019/8/3.
 */

public class SingerFragment extends BaseFragment {
    View rootView;
    RecyclerView singer_recycler;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.singer_layout, null);
        }
        singer_recycler = (RecyclerView) rootView.findViewById(R.id.singer_recycler);
        singer_recycler.setAdapter(new SingerAdapter(mContext));
        singer_recycler.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false));
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
