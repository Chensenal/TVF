package mefragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.master.tvf.R;

import java.util.ArrayList;

import base.BaseFragment;
import mefragment.bean.SongList;
import mefragment.meadapter.MeAdapter;


/**
 * Created by master on 2019/7/27.
 */

public class MeFragment extends BaseFragment {

    View rootView;
    ListView me_lv;
    private ArrayList<SongList> songLists;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.me_layout, null);
        }
//        songLists = new ArrayList<>();
//        songLists.add(new SongList("歌1",1,2));
        me_lv = (ListView) rootView.findViewById(R.id.me_lv);
        me_lv.setAdapter(new MeAdapter(mContext, songLists));
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
        Log.e("我的","我的Fragment主页面的内容");
    }
}
