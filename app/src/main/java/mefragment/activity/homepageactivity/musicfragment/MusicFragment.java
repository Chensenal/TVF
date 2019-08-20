package mefragment.activity.homepageactivity.musicfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.tvf.R;

import base.BaseFragment;
import mefragment.activity.homepageactivity.musicfragment.musicadapter.MusicAdapter;

/**
 * Created by master on 2019/8/5.
 */

public class MusicFragment extends BaseFragment {
    View rootView;
    RecyclerView music_recyclerview;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.music_layout, null);
        }
        music_recyclerview = (RecyclerView) rootView.findViewById(R.id.music_recycler);
        music_recyclerview.setAdapter(new MusicAdapter(mContext));
        music_recyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

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
        Log.e("音乐","音乐Fragment的内容");
    }

}
