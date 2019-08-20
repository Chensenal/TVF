package mefragment.activity.homepageactivity.datafragment.dataadapter.datamedaladapter;

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

public class MedalAdapter extends RecyclerView.Adapter<MedalAdapter.AdapterViewHolder> implements View.OnClickListener{

    private Context mcontext;
    private FragmentActivity activity;

    @Override
    public MedalAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.medal_item,null);
        return new  MedalAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView medal_iv_music;
        private TextView medal_tv_title;
        private TextView medal_tv_comment;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            medal_iv_music = (ImageView) itemView.findViewById(R.id.medal_iv_music);
            medal_tv_title = (TextView)itemView.findViewById(R.id.medal_tv_title);
            medal_tv_comment = (TextView)itemView.findViewById(R.id.medal_tv_comment);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_settings:{

            }
        }
    }

    public
    MedalAdapter(Context mcontext,FragmentActivity activity) {
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
    public void onBindViewHolder(MedalAdapter.AdapterViewHolder holder, int position) {

        holder.medal_iv_music.setImageResource(R.drawable.my_user_default);
        holder.medal_tv_comment.setText("粉丝勋章的评价");
        holder.medal_tv_title.setText("粉丝勋章的标题");



    }



    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return 1;
    }
}
