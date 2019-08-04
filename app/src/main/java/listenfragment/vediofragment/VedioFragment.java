package listenfragment.vediofragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.master.tvf.R;

import base.BaseFragment;
import listenfragment.vediofragment.adapter.VedioAdapter;

/**
 * Created by master on 2019/7/28.
 */

public class VedioFragment extends BaseFragment {
    View rootView;
    GridView listen_vedio_gridview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.vedio_layout, null);
        }
        listen_vedio_gridview = (GridView) rootView.findViewById(R.id.listen_vedio_gridview);
        listen_vedio_gridview.setAdapter(new VedioAdapter(mContext));
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
        Log.e("视频","视频Fragment的内容");
    }
}
