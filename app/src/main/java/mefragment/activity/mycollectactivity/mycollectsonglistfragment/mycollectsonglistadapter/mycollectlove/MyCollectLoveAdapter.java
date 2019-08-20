package mefragment.activity.mycollectactivity.mycollectsonglistfragment.mycollectsonglistadapter.mycollectlove;

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

public class MyCollectLoveAdapter extends RecyclerView.Adapter<MyCollectLoveAdapter.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public MyCollectLoveAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.mycollectlove_item,null);
        return new MyCollectLoveAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView mycollectlove_iv_diaplay;
        private TextView mycollectlove_tv_titlet;
        private TextView mycollectlove_tv_editor;
        private TextView mycollect_tv_time;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            mycollectlove_iv_diaplay = (ImageView)itemView.findViewById(R.id.mycollectlove_iv_diaplay);
            mycollectlove_tv_titlet = (TextView)itemView.findViewById(R.id.mycollectlove_tv_title);
            mycollectlove_tv_editor = (TextView)itemView.findViewById(R.id.mycollectlove_tv_editor);
            mycollect_tv_time = (TextView)itemView.findViewById(R.id.mycollect_tv_time);
        }

    }

    public MyCollectLoveAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(MyCollectLoveAdapter.AdapterViewHolder holder, int position) {
        holder.mycollectlove_tv_editor.setText(titles[position]);
        holder.mycollectlove_tv_titlet.setText(titles[position]);
        holder.mycollectlove_iv_diaplay.setImageResource(ids[position]);
        holder.mycollect_tv_time.setText(titles[position]);

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

