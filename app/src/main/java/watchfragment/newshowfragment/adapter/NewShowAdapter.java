package watchfragment.newshowfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import watchfragment.singerfragment.adapter.SingerAdapter;

/**
 * Created by master on 2019/8/4.
 */

public class NewShowAdapter  extends RecyclerView.Adapter<NewShowAdapter.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public NewShowAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext,R.layout.newshow_item,null);
        return new NewShowAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView newshow_imageview;
        private TextView newshow_title;
        private TextView newshow_content;
        public AdapterViewHolder(View itemView) {

            super(itemView);
            newshow_imageview = (ImageView) itemView.findViewById(R.id.newshow_imageView);
            newshow_title = (TextView)itemView.findViewById(R.id.newshow_title);
            newshow_content = (TextView)itemView.findViewById(R.id.newshow_content);
        }

    }

    public NewShowAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(NewShowAdapter.AdapterViewHolder holder, int position) {
        holder.newshow_title.setText(titles[position]);
        holder.newshow_imageview.setImageResource(ids[position]);
        holder.newshow_content.setText(titles[position]);
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

