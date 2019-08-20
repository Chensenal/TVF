package mefragment.activity.homepageactivity.supermenfragment.supermenadapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

/**
 * Created by master on 2019/8/7.
 */

public class SuperAdapter extends RecyclerView.Adapter<SuperAdapter.AdapterViewHolder> implements View.OnClickListener{

    private Context mcontext;
    private FragmentActivity activity;

    @Override
    public SuperAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.supermen_item,null);
        return new  SuperAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView supermen_iv_technology;
        private TextView supermen_tv_title;
        private TextView supermen_tv_content1;
        private TextView supermen_tv_content2;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            supermen_iv_technology = (ImageView)itemView.findViewById(R.id.supermen_iv_technology);
            supermen_tv_title = (TextView)itemView.findViewById(R.id.supermen_tv_title);
            supermen_tv_content1 = (TextView)itemView.findViewById(R.id.supermen_tv_content1);
            supermen_tv_content2 = (TextView)itemView.findViewById(R.id.supermen_tv_content2);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    public
    SuperAdapter(Context mcontext,FragmentActivity activity) {
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
    public void onBindViewHolder(SuperAdapter.AdapterViewHolder holder, int position) {
        holder.supermen_iv_technology.setImageResource(R.drawable.my_user_default);
        holder.supermen_tv_content1.setText("获得官方推荐");
        holder.supermen_tv_content2.setText("收获什么鬼");

    }





    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return 1;
    }
}
