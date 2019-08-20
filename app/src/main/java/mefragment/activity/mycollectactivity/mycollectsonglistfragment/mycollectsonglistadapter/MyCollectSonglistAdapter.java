package mefragment.activity.mycollectactivity.mycollectsonglistfragment.mycollectsonglistadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.master.tvf.R;

import mefragment.activity.mycollectactivity.mycollectsonglistfragment.mycollectsonglistadapter.mycollectlove.MyCollectLoveAdapter;
import mefragment.activity.mycollectactivity.mycollectsonglistfragment.mycollectsonglistadapter.mycollectselfsongistadapter.MyCollectSelfSonglistAdapter;
import watchfragment.specialfragment.adapter.SpecialAdapater;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectSonglistAdapter extends RecyclerView.Adapter<MyCollectSonglistAdapter.AdapterViewHolder> {
    private Context mcontext;
    boolean currentflag = false;
    boolean changeflag = false;
    @Override
    public MyCollectSonglistAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.mycollectsonglist_item,null);
        return new  MyCollectSonglistAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView mycollectsonglist_iv_add;
        private TextView mycollectsonglist_tv_add;
        private TextView mycollectsonglist_tv_count;
        private ImageView mycollectsonglist_iv_below;
        private TextView mycollectsonglist_tv_songlistcount;
        private TextView mycollectsonglist_tv_playlist;
        private  TextView mycollectsonglist_tv_maneage;
        private  RecyclerView mycollectsonglist_songlist_recyclerview;
        private TextView mycollectsonglist_yourlove_songlist;
        private RecyclerView mycollectsonglist_songlist_love_recyclerview;
        private TextView mycollectsonglist_found;
        private RelativeLayout mycollectsonglist_rl;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            mycollectsonglist_iv_add = (ImageView)itemView.findViewById(R.id.mycollectsonglist_iv_add);
            mycollectsonglist_tv_add = (TextView)itemView.findViewById(R.id.mycollectsonglist_tv_add);
            mycollectsonglist_tv_count  = (TextView)itemView.findViewById(R.id.mycollectsonglist_tv_count);
            mycollectsonglist_iv_below = (ImageView)itemView.findViewById(R.id.mycollectsonglist_iv_below);
            mycollectsonglist_tv_songlistcount = (TextView)itemView.findViewById(R.id.mycollectsonglist_tv_songlistcount);
            mycollectsonglist_tv_playlist = (TextView)itemView.findViewById(R.id.mycollectsonglist_tv_playlist);
            mycollectsonglist_tv_maneage = (TextView)itemView.findViewById(R.id.mycollectsonglist_tv_maneage);
            mycollectsonglist_songlist_recyclerview = (RecyclerView)itemView.findViewById(R.id.mycollectsonglist_songlist_recyclerview);
            mycollectsonglist_yourlove_songlist = (TextView)itemView.findViewById(R.id.mycollectsonglist_yourlove_songlist);
            mycollectsonglist_songlist_love_recyclerview = (RecyclerView)itemView.findViewById(R.id.mycollectsonglist_songlist_love_recyclerview);
            mycollectsonglist_found = (TextView)itemView.findViewById(R.id.mycollectsonglist_found);
            mycollectsonglist_rl = (RelativeLayout)itemView.findViewById(R.id.mycollectsonglist_rl);
        }

    }



    public MyCollectSonglistAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(final MyCollectSonglistAdapter.AdapterViewHolder holder, int position) {

       holder.mycollectsonglist_iv_add.setImageResource(R.drawable.add_btn);
        holder.mycollectsonglist_tv_add.setText("新建");
        holder.mycollectsonglist_tv_count.setText("云歌曲数:");
        holder.mycollectsonglist_tv_playlist.setText("导入歌单");
        holder.mycollectsonglist_tv_maneage.setText("管理");
        holder.mycollectsonglist_iv_below.setImageResource(R.drawable.left);
        holder.mycollectsonglist_tv_songlistcount.setText("自建歌单/3");
        holder.mycollectsonglist_songlist_recyclerview.setAdapter(new MyCollectSelfSonglistAdapter(mcontext));
        holder.mycollectsonglist_songlist_recyclerview.setLayoutManager(new LinearLayoutManager(mcontext,LinearLayoutManager.VERTICAL,false));
        holder.mycollectsonglist_yourlove_songlist.setText("你可能喜欢的歌单");
        holder.mycollectsonglist_songlist_love_recyclerview.setAdapter(new MyCollectLoveAdapter(mcontext));
        holder.mycollectsonglist_songlist_love_recyclerview.setLayoutManager(new GridLayoutManager(mcontext,3,LinearLayoutManager.VERTICAL,false));
        holder.mycollectsonglist_found.setText("发现更好的音乐");



        holder.mycollectsonglist_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(holder.mycollectsonglist_songlist_recyclerview.getVisibility()==View.VISIBLE){
                    holder.mycollectsonglist_songlist_recyclerview.setVisibility(View.GONE);
                }else{
                    holder.mycollectsonglist_songlist_recyclerview.setVisibility(View.VISIBLE);
                }

            }
        });
    }
    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return 1;
    }

    private String titles[] = {"乐库", "歌单", "电台·听书", "猜你喜欢", "每日推荐", "更多"};
    private Integer ids[] = {R.drawable.search, R.drawable.search, R.drawable.search, R.drawable.search, R.drawable.search, R.drawable.search};
}

