package watchfragment.attentionfragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

/**
 * Created by master on 2019/8/3.
 */

public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.AdapterViewHolder> {
    private Context mcontext;
    class AdapterViewHolder extends RecyclerView.ViewHolder{
        private  ImageView attention_imageView;
        private  TextView attention_title;
        public AdapterViewHolder(View itemView){
            super(itemView);
            attention_imageView = (ImageView) itemView.findViewById(R.id.attention_imageView);
            attention_title = (TextView)itemView.findViewById(R.id.attention_title);


        }

    }
    public AttentionAdapter(Context mcontext){
        this.mcontext = mcontext;

    }
    /*
相当于getView方法中创建view和ViewHolder
     */
    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext,R.layout.attention_item,null);
        return new AdapterViewHolder(itemView);
    }
    /*
     相当于getView绑定数据部分的代码
     */
    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {

            holder.attention_imageView.setImageResource(ids[position]);
            holder.attention_title.setText(titles[position]);
    }
    /*
    得到总数
     */
    @Override
    public int getItemCount() {
        return ids.length;
    }
    private String titles[] ={"乐库","歌单","电台·听书","猜你喜欢","每日推荐","更多"};
    private Integer ids[]={R.drawable.search,R.drawable.search,R.drawable.search, R.drawable.search,R.drawable.search,R.drawable.search};
}
