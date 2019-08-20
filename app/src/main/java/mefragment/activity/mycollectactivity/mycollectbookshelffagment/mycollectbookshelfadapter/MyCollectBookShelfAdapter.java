package mefragment.activity.mycollectactivity.mycollectbookshelffagment.mycollectbookshelfadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import mefragment.activity.mycollectactivity.mycollectvediofragment.mycollectvedioadapter.MyCollectVedioAdapter;

/**
 * Created by master on 2019/8/9.
 */

public class MyCollectBookShelfAdapter extends RecyclerView.Adapter<MyCollectBookShelfAdapter.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public MyCollectBookShelfAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.mycollectbookshelf_item,null);
        return new MyCollectBookShelfAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView mycollectbookshelf_iv_display;
        private TextView mycollectbookshelf_tv_title;
        private TextView mycollectbookshelf_tv_count;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            mycollectbookshelf_iv_display = (ImageView) itemView.findViewById(R.id.mycollectbookshelf_iv_display);
            mycollectbookshelf_tv_title = (TextView)itemView.findViewById(R.id.mycollectbookshelf_tv_title);
            mycollectbookshelf_tv_count  =(TextView)itemView.findViewById(R.id.mycollectbookshelf_tv_count);
        }

    }

    public MyCollectBookShelfAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(MyCollectBookShelfAdapter.AdapterViewHolder holder, int position) {
        holder.mycollectbookshelf_iv_display.setImageResource(ids[position]);
        holder.mycollectbookshelf_tv_count.setText(titles[position]);
        holder.mycollectbookshelf_tv_title.setText(titles[position]);
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

