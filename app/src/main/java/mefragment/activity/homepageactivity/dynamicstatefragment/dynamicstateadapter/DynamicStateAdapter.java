package mefragment.activity.homepageactivity.dynamicstatefragment.dynamicstateadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

/**
 * Created by master on 2019/8/6.
 */

public class DynamicStateAdapter extends RecyclerView.Adapter<DynamicStateAdapter.AdapterViewHolder> implements View.OnClickListener {

    private Context mcontext;

    @Override
    public DynamicStateAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.dynamicstate_item, null);
        return new DynamicStateAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView dynamicstate_iv_touxiang;
        private TextView dynamicstate_username;
        private TextView dynamicstate_tv_time;
        private TextView dynamicstate_tv_collect;
        private ImageView dynamicstate_iv_delete;
        private TextView dynamicstate_tv_content;
        private ImageView dynamicstate_iv_music;
        private ImageView dynamicstate_iv_comment;
        private TextView dynamicstate_tv_comment;
        private  ImageView dynamicstate_iv_like;
        private TextView dynamicstate_tv_like;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            dynamicstate_iv_touxiang  = (ImageView) itemView.findViewById(R.id.dynamicstate_iv_touxiang);
            dynamicstate_username = (TextView)itemView.findViewById(R.id.dynamicstate_username);
            dynamicstate_tv_time = (TextView)itemView.findViewById(R.id.dynamicstate_tv_time);
            dynamicstate_tv_collect = (TextView)itemView.findViewById(R.id.dynamicstate_tv_collect);
            dynamicstate_iv_delete = (ImageView)itemView.findViewById(R.id.dynamicstate_iv_delete);
            dynamicstate_tv_content = (TextView)itemView.findViewById(R.id.dynamicstate_tv_content);
            dynamicstate_iv_music = (ImageView) itemView.findViewById(R.id.dynamicstate_iv_music);
            dynamicstate_iv_comment = (ImageView)itemView.findViewById(R.id.dynamicstate_iv_comment);
            dynamicstate_tv_comment = (TextView)itemView.findViewById(R.id.dynamicstate_tv_comment);
            dynamicstate_iv_like = (ImageView)itemView.findViewById(R.id.dynamicstate_iv_like);
            dynamicstate_tv_like = (TextView)itemView.findViewById(R.id.dynamicstate_tv_like);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    public DynamicStateAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(DynamicStateAdapter.AdapterViewHolder holder, int position) {
        holder.dynamicstate_iv_touxiang.setImageResource(ids[position]);
        holder.dynamicstate_username.setText(titles[position]);
        holder.dynamicstate_tv_time.setText(titles[position]);
        holder.dynamicstate_tv_collect.setText(titles[position]);
        holder.dynamicstate_iv_delete.setImageResource(ids[position]);
        holder.dynamicstate_tv_content.setText(titles[position]);
        holder.dynamicstate_iv_music.setImageResource(ids[position]);
        holder.dynamicstate_iv_comment.setImageResource(ids[position]);
        holder.dynamicstate_tv_comment.setText(titles[position]);
        holder.dynamicstate_iv_like.setImageResource(ids[position]);
        holder.dynamicstate_tv_like.setText(titles[position]);





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
