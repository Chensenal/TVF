package listenfragment.newsongfragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.master.tvf.R;

import base.BaseFragment;
import listenfragment.newsongfragment.adapter.NewSongAdapter;

/**
 * Created by master on 2019/7/28.
 */

public class NewSongFragment extends BaseFragment {
    View rootView;
    ListView newsong_listview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.newsong_layout, null);
        }
        newsong_listview = (ListView) rootView.findViewById(R.id.newsong_listview);
        newsong_listview.setAdapter(new NewSongAdapter(mContext));
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
        Log.e("新歌","新歌Fragment的内容");
    }
}
