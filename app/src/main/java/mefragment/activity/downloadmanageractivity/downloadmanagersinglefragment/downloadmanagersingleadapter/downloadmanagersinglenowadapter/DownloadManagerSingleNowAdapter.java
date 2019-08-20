package mefragment.activity.downloadmanageractivity.downloadmanagersinglefragment.downloadmanagersingleadapter.downloadmanagersinglenowadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import mefragment.activity.homepageactivity.musicfragment.musicadapter.MusicAdapter;

/**
 * Created by master on 2019/8/10.
 */

public class DownloadManagerSingleNowAdapter extends RecyclerView.Adapter<DownloadManagerSingleNowAdapter.AdapterViewHolder> implements View.OnClickListener {

    private Context mcontext;

    @Override
    public DownloadManagerSingleNowAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.downloadmanagersinglenow_item, null);
        return new DownloadManagerSingleNowAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView downloadmanagersingle_iv_now_stop;
        private TextView downloadmanagersingle_tv_now_title;
        private  TextView downloadmanagersingle_tv_now_editor;
        private FrameLayout downloadmanagersingle_fragmentlayout;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            downloadmanagersingle_iv_now_stop = (ImageView)itemView.findViewById(R.id.downloadmanagersingle_iv_now_stop);
            downloadmanagersingle_tv_now_title = (TextView)itemView.findViewById(R.id.downloadmanagersingle_tv_now_title);
            downloadmanagersingle_tv_now_editor = (TextView)itemView.findViewById(R.id.downloadmanagersingle_tv_now_editor);
            downloadmanagersingle_fragmentlayout = (FrameLayout)itemView.findViewById(R.id.downloadmanagersingle_fragmentlayout);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    public DownloadManagerSingleNowAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(final DownloadManagerSingleNowAdapter.AdapterViewHolder holder, int position) {
        holder.downloadmanagersingle_iv_now_stop.setImageResource(R.drawable.left);
        holder.downloadmanagersingle_tv_now_title.setText("321312");
        holder.downloadmanagersingle_tv_now_editor.setText("sdfisdj");
        holder.downloadmanagersingle_iv_now_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.downloadmanagersingle_iv_now_stop:{
                        if(holder.downloadmanagersingle_fragmentlayout.getVisibility()==View.VISIBLE){
                            holder.downloadmanagersingle_fragmentlayout.setVisibility(View.GONE);
                        }else{
                            holder.downloadmanagersingle_fragmentlayout.setVisibility(View.VISIBLE);
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
        return 1;
    }

}

