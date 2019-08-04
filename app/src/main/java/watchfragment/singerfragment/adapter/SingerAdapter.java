package watchfragment.singerfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import watchfragment.nearfragment.adapter.NearAdapter;
import watchfragment.newshowfragment.adapter.NewShowAdapter;

/**
 * Created by master on 2019/8/4.
 */

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public SingerAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext,R.layout.singer_item,null);
        return new SingerAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView singer_imageview;
        private TextView singer_title;
        private TextView singer_content;
        public AdapterViewHolder(View itemView) {

            super(itemView);
            singer_imageview = (ImageView) itemView.findViewById(R.id.singer_imageView);
            singer_title = (TextView) itemView.findViewById(R.id.singer_title);
            singer_content = (TextView)itemView.findViewById(R.id.singer_content);
        }

    }

    public SingerAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(SingerAdapter.AdapterViewHolder holder, int position) {
            holder.singer_title.setText(titles[position]);
            holder.singer_imageview.setImageResource(ids[position]);
            holder.singer_content.setText(titles[position]);
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
