package watchfragment.recomendfragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.master.tvf.R;

import base.BaseFragment;

/**
 * Created by master on 2019/8/2.
 */

public class RecomendFragment extends BaseFragment {
    View rootView;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.recomend_layout, null);
        }
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
