package mefragment.activity.homepageactivity.musicfragment.musicadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;


/**
 * Created by master on 2019/8/6.
 */

public class MusicAdapter  extends RecyclerView.Adapter<MusicAdapter.AdapterViewHolder> implements View.OnClickListener {

    private Context mcontext;

    @Override
    public MusicAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.music_item, null);
        return new MusicAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView music_iv_display;
        private TextView music_title;
        private  TextView music_content;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            music_iv_display = (ImageView)itemView.findViewById(R.id.music_iv_display);
            music_title = (TextView)itemView.findViewById(R.id.music_title);
            music_content = (TextView) itemView.findViewById(R.id.music_content);

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    public MusicAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(MusicAdapter.AdapterViewHolder holder, int position) {
        holder.music_iv_display.setImageResource(R.drawable.my_user_default);
        holder.music_title.setText("标题");
        holder.music_content.setText("内容");




    }
    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return 1;
    }

}
