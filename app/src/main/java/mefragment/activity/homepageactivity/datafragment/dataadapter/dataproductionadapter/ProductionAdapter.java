package mefragment.activity.homepageactivity.datafragment.dataadapter.dataproductionadapter;

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

public class ProductionAdapter extends RecyclerView.Adapter<ProductionAdapter.AdapterViewHolder> implements View.OnClickListener{

    private Context mcontext;
    private FragmentActivity activity;

    @Override
    public ProductionAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.production_item,null);
        return new  ProductionAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView production_iv_music;
        private TextView production_tv_title;
        private TextView production_tv_comment;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            production_iv_music = (ImageView) itemView.findViewById(R.id.production_iv_music);
            production_tv_title = (TextView)itemView.findViewById(R.id.production_tv_title);
            production_tv_comment = (TextView)itemView.findViewById(R.id.production_tv_comment);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    public
    ProductionAdapter(Context mcontext,FragmentActivity activity) {
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
    public void onBindViewHolder(ProductionAdapter.AdapterViewHolder holder, int position) {
        holder.production_iv_music.setImageResource(R.drawable.my_user_default);
        holder.production_tv_comment.setText("成就的评价");
        holder.production_tv_title.setText("成就的标题");
    }





    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return 1;
    }
}
