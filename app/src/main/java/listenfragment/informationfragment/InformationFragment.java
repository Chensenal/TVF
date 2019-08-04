package listenfragment.informationfragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;

/**
 * Created by master on 2019/7/28.
 */

public class  InformationFragment extends BaseFragment {
   View rootView;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext,R.layout.information_layout,null);
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
        Log.e("咨讯","咨讯Fragment的内容");
    }
}
