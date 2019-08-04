package listenfragment.livefragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.master.tvf.R;

import base.BaseFragment;
import listenfragment.livefragment.adapter.LiveGridViewAdapter;

/**
 * Created by master on 2019/7/28.
 */

public class LiveFragment extends BaseFragment {
    View rootView;
    GridView live_gridview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.live_layout, null);
        }
        live_gridview = (GridView)rootView.findViewById(R.id.live_gridview);

        live_gridview.setAdapter(new LiveGridViewAdapter(mContext));
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
        Log.e("直播","直播Fragment的内容");
    }
}
