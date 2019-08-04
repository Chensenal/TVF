package singfragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;

/**
 * Created by master on 2019/7/27.
 */

public class SingFragment extends BaseFragment {
    View rootView;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.sing_layout, null);
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
        Log.e("唱的","唱的Fragment主页面的内容");
    }
}
