package mefragment.activity.mycollectactivity.mycollectsonglistfragment.mycollectsonglistadapter.mycollectselfsongistadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectSelfSonglistAdapter extends RecyclerView.Adapter<MyCollectSelfSonglistAdapter.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public MyCollectSelfSonglistAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.mycollect_songlist_self_item,null);
        return new MyCollectSelfSonglistAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView mycollect_iv_songlist;
        private TextView mycollect_tv_songlist;
        private TextView mycollect_tv_songlist_collect;
        private TextView mycollect_tv_songlist_download;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            mycollect_iv_songlist = (ImageView) itemView.findViewById(R.id.mycollect_iv_songlist);
            mycollect_tv_songlist = (TextView)itemView.findViewById(R.id.mycollect_tv_songlist);
            mycollect_tv_songlist_collect = (TextView)itemView.findViewById(R.id.mycollect_tv_songlist_collect);
            mycollect_tv_songlist_download = (TextView)itemView.findViewById(R.id.mycollect_tv_songlist_download);
        }

    }

    public MyCollectSelfSonglistAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(MyCollectSelfSonglistAdapter.AdapterViewHolder holder, int position) {
            holder.mycollect_iv_songlist.setImageResource(ids[position]);
            holder.mycollect_tv_songlist.setText(titles[position]);
            holder.mycollect_tv_songlist_collect.setText(titles[position]);
            holder.mycollect_tv_songlist_download.setText(titles[position]);
    }

    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return ids.length;
    }

    private String titles[] = {"乐库", "歌单", "电台·听书", "猜你喜欢", "每日推荐", "更多"};
    private Integer ids[] = {R.drawable.search, R.drawable.search, R.drawable.search, R.drawable.search, R.drawable.search, R.drawable.search};
}

