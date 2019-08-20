package mefragment.activity.mycollectactivity.mycollectvediofragment.mycollectvedioadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import mefragment.activity.mycollectactivity.mycollectsonglistfragment.mycollectsonglistadapter.mycollectlove.MyCollectLoveAdapter;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectVedioAdapter  extends RecyclerView.Adapter<MyCollectVedioAdapter.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public MyCollectVedioAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.mycollectvedio_item,null);
        return new MyCollectVedioAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView mycollectvedio_iv_display;
        private TextView mycollectvedio_tv_title;
        private TextView mycollectvedio_tv_editor;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            mycollectvedio_iv_display = (ImageView)itemView.findViewById(R.id.mycollectvedio_iv_display);
            mycollectvedio_tv_title = (TextView)itemView.findViewById(R.id.mycollectvedio_tv_title);
            mycollectvedio_tv_editor = (TextView)itemView.findViewById(R.id.mycollectvedio_tv_editor);
        }

    }

    public MyCollectVedioAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(MyCollectVedioAdapter.AdapterViewHolder holder, int position) {
        holder.mycollectvedio_iv_display.setImageResource(ids[position]);
        holder.mycollectvedio_tv_title.setText(titles[position]);
        holder.mycollectvedio_tv_editor.setText(titles[position]);
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
