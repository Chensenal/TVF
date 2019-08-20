package mefragment.activity.downloadmanageractivity.downloadmanagersinglefragment.downloadmanagersingleadapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;
/**
 * Created by master on 2019/8/9.
 */

public class DownLoadManagerSingleAdapter  extends RecyclerView.Adapter<DownLoadManagerSingleAdapter.AdapterViewHolder> implements View.OnClickListener {

    private Context mcontext;

    @Override
    public DownLoadManagerSingleAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.downloadmanagersingle_item, null);
        return new DownLoadManagerSingleAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView downloadmanagersingle_iv_now_below;
        private TextView downloadmanagersingle_tv_now;
        private  TextView downloadmanagersingle_tv_clear;
        private ImageView downloadmanagersingle_iv_total_start;
        private TextView downloadmanagersingle_tv_total_start;
        private ImageView downloadmanagersingle_iv_total_stop;
        private TextView downloadmanagersingle_tv_total_stop;
        private RecyclerView downloadmanagersingle_now_recyclerview;
        private ImageView downloadmanagersingle_iv_already_below;
        private TextView downloadmanagersingle_tv_already;
        private TextView downloadmanagersingle_tv_already_clear;
        private TextView downloadmanagersingle_tv_already_chooose;
        private RecyclerView downloadmanagersingle_already_recyclerview;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            downloadmanagersingle_iv_now_below = (ImageView) itemView.findViewById(R.id.downloadmanagersingle_iv_now_below);
            downloadmanagersingle_tv_now = (TextView) itemView.findViewById(R.id.downloadmanagersingle_tv_now);
            downloadmanagersingle_tv_clear = (TextView) itemView.findViewById(R.id.downloadmanagersingle_tv_clear);
            downloadmanagersingle_iv_total_start = (ImageView) itemView.findViewById(R.id.downloadmanagersingle_iv_total_start);
            downloadmanagersingle_tv_total_start = (TextView) itemView.findViewById(R.id.downloadmanagersingle_tv_total_start);
            downloadmanagersingle_iv_total_stop = (ImageView)itemView.findViewById(R.id.downloadmanagersingle_iv_total_stop);
            downloadmanagersingle_tv_total_stop = (TextView)itemView.findViewById(R.id.downloadmanagersingle_tv_total_stop);
            downloadmanagersingle_now_recyclerview = (RecyclerView)itemView.findViewById(R.id.downloadmanagersingle_now_recyclerview);
            downloadmanagersingle_already_recyclerview = (RecyclerView)itemView.findViewById(R.id.downloadmanagersingle_already_recyclerview);
            downloadmanagersingle_iv_already_below = (ImageView)itemView.findViewById(R.id.downloadmanagersingle_iv_already_below);
            downloadmanagersingle_tv_already = (TextView)itemView.findViewById(R.id.downloadmanagersingle_tv_already);
            downloadmanagersingle_tv_already_clear = (TextView)itemView.findViewById(R.id.downloadmanagersingle_tv_already_clear);
            downloadmanagersingle_tv_already_chooose = (TextView)itemView.findViewById(R.id.downloadmanagersingle_tv_already_chooose);
        }
    }



    public DownLoadManagerSingleAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(final DownLoadManagerSingleAdapter.AdapterViewHolder holder, int position) {
        holder.downloadmanagersingle_iv_now_below.setImageResource(R.drawable.left);
        holder.downloadmanagersingle_tv_now.setText("正在下载");
        holder.downloadmanagersingle_tv_clear.setText("清空");
        holder.downloadmanagersingle_iv_total_start.setImageResource(R.drawable.left);
        holder.downloadmanagersingle_tv_total_start.setText("全部开始");
        holder.downloadmanagersingle_iv_total_stop.setImageResource(R.drawable.left);
        holder.downloadmanagersingle_tv_total_stop.setText("全部暂停");
        holder.downloadmanagersingle_iv_already_below.setImageResource(R.drawable.left);
        holder.downloadmanagersingle_tv_already.setText("已下载");
        holder.downloadmanagersingle_tv_already_clear.setText("清空");
        holder.downloadmanagersingle_tv_already_chooose.setText("多选");
        holder.downloadmanagersingle_now_recyclerview.setLayoutManager(new LinearLayoutManager(mcontext,LinearLayoutManager.VERTICAL,false));
        holder.downloadmanagersingle_already_recyclerview.setLayoutManager(new LinearLayoutManager(mcontext,LinearLayoutManager.VERTICAL,false));


        initClick(holder);

    }

    @Override
    public void onClick(View view) {

    }

    private void initClick(final DownLoadManagerSingleAdapter.AdapterViewHolder holder){
    holder.downloadmanagersingle_iv_now_below.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.downloadmanagersingle_iv_total_start:{
                    if(holder.downloadmanagersingle_now_recyclerview.getVisibility()==View.VISIBLE){
                        holder.downloadmanagersingle_now_recyclerview.setVisibility(View.GONE);
                    }else {
                        holder.downloadmanagersingle_now_recyclerview.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    });
        holder.downloadmanagersingle_iv_already_below.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.downloadmanagersingle_iv_already_below:{
                        if(holder.downloadmanagersingle_already_recyclerview.getVisibility()==View.VISIBLE){
                            holder.downloadmanagersingle_already_recyclerview.setVisibility(View.GONE);
                        }else {
                            holder.downloadmanagersingle_already_recyclerview.setVisibility(View.VISIBLE);
                        }
                    }

                }
            }
        });

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

