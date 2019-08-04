package watchfragment.nearfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;



/**
 * Created by master on 2019/8/4.
 */

public class NearAdapter extends RecyclerView.Adapter<NearAdapter.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = View.inflate(mcontext,R.layout.near_item,null);
        return new NearAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView near_imageview;
        private TextView near_title;
        private TextView near_content;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            near_imageview = (ImageView)itemView.findViewById(R.id.near_imageView);
            near_title = (TextView) itemView.findViewById(R.id.near_title);
            near_content = (TextView)itemView.findViewById(R.id.near_content);

        }

    }

    public NearAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        holder.near_imageview.setImageResource(ids[position]);
        holder.near_title.setText(titles[position]);
        holder.near_content.setText(titles[position]);
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
