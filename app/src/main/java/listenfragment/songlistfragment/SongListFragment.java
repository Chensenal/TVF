package listenfragment.songlistfragment;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.master.tvf.R;

import base.BaseFragment;
import listenfragment.songlistfragment.adapter.SongListAdapter;

/**
 * Created by master on 2019/7/28.
 */

public class SongListFragment extends BaseFragment {
    View rootView;
    ListView listen_songlist_lv;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.listen_songlist_layout, null);
        }
        listen_songlist_lv = (ListView) rootView.findViewById(R.id.listen_songlist_lv);
        listen_songlist_lv.setAdapter(new SongListAdapter(mContext));
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
        Log.e("歌单","歌单Fragment的内容");
    }
}
