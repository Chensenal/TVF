package watchfragment.specialfragment.adapter;

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

public class SpecialAdapater extends RecyclerView.Adapter<SpecialAdapater.AdapterViewHolder> {
    private Context mcontext;

    @Override
    public SpecialAdapater.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext,R.layout.special_item,null);
        return new  SpecialAdapater.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView special_imageview;
        private TextView special_title;
        private TextView special_content;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            special_imageview = (ImageView) itemView.findViewById(R.id.special_imageView);
            special_title = (TextView) itemView.findViewById(R.id.special_title);
            special_content = (TextView)itemView.findViewById(R.id.special_content);
        }

    }

    public SpecialAdapater(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(SpecialAdapater.AdapterViewHolder holder, int position) {
            holder.special_title.setText(titles[position]);
            holder.special_imageview.setImageResource(ids[position]);
            holder.special_content.setText(titles[position]);
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

