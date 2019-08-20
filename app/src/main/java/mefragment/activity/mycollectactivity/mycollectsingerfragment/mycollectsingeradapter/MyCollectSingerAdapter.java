package mefragment.activity.mycollectactivity.mycollectsingerfragment.mycollectsingeradapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import mefragment.activity.mycollectactivity.mycollectsonglistfragment.mycollectsonglistadapter.MyCollectSonglistAdapter;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectSingerAdapter extends RecyclerView.Adapter<MyCollectSingerAdapter.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public MyCollectSingerAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.mycollectsinger_item,null);
        return new  MyCollectSingerAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView mycollectsinger_iv_display;
        private TextView mycollectsinger_tv_editor;
        private TextView mycollectsinger_tv_fanscount;
        private ImageView mycollectsinger_iv_right;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            mycollectsinger_iv_display = (ImageView)itemView.findViewById(R.id.mycollectsinger_iv_display);
            mycollectsinger_tv_editor = (TextView)itemView.findViewById(R.id.mycollectsinger_tv_editor);
            mycollectsinger_tv_fanscount = (TextView)itemView.findViewById(R.id.mycollectsinger_tv_fanscount);
            mycollectsinger_iv_right = (ImageView)itemView.findViewById(R.id.mycollectsinger_iv_right);
        }

    }

    public MyCollectSingerAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(MyCollectSingerAdapter.AdapterViewHolder holder, int position) {
            holder.mycollectsinger_iv_display.setImageResource(ids[position]);
            holder.mycollectsinger_tv_editor.setText(titles[position]);
            holder.mycollectsinger_tv_fanscount.setText(titles[position]);
            holder.mycollectsinger_iv_right.setImageResource(ids[position]);
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


