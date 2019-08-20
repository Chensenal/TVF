package mefragment.activity.homepageactivity.datafragment.dataadapter.dataachevementadapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

/**
 * Created by master on 2019/8/6.
 */

public class AchevementAdapter extends RecyclerView.Adapter<AchevementAdapter.AdapterViewHolder> implements View.OnClickListener{

    private Context mcontext;
    private FragmentActivity activity;

    @Override
    public AchevementAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.achevement_item,null);
        return new  AchevementAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView achevement_iv_music;
        private TextView achevement_tv_title;
        private TextView achevement_tv_comment;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            achevement_iv_music = (ImageView) itemView.findViewById(R.id.achevement_iv_music);
            achevement_tv_title = (TextView)itemView.findViewById(R.id.achevement_tv_title);
            achevement_tv_comment = (TextView)itemView.findViewById(R.id.achevement_tv_comment);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    public
    AchevementAdapter(Context mcontext,FragmentActivity activity) {
        this.mcontext = mcontext;
        this.activity = activity;
    }
    /*
相当于getView方法中创建view和ViewHolder
     */

    /*
     相当于getView绑定数据部分的代码
     */

    @Override
    public void onBindViewHolder(AchevementAdapter.AdapterViewHolder holder, int position) {
        holder.achevement_iv_music.setImageResource(R.drawable.my_user_default);
        holder.achevement_tv_comment.setText("成就的评价");
        holder.achevement_tv_title.setText("成就的标题");
    }





    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return 1;
    }
}
