package mefragment.activity.homepageactivity.datafragment.dataadapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.master.tvf.R;

import mefragment.activity.homepageactivity.datafragment.dataadapter.dataachevementadapter.AchevementAdapter;
import mefragment.activity.homepageactivity.datafragment.dataadapter.datamedaladapter.MedalAdapter;
import mefragment.activity.homepageactivity.datafragment.dataadapter.dataproductionadapter.ProductionAdapter;

/**
 * Created by master on 2019/8/6.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.AdapterViewHolder> implements View.OnClickListener{

    private Context mcontext;
    private FragmentActivity activity;

    @Override
    public DataAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mcontext, R.layout.data_item,null);
        return new  DataAdapter.AdapterViewHolder(itemView);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView data_tv_persongal;
        private TextView data_tv_age;
        private TextView data_tv_medal;
        private RecyclerView data_medal_recyclerview;
        private TextView data_tv_achevement;
        private RecyclerView data_achevement_recyclerview;
        private  TextView data_production;
        private RecyclerView data_production_recyclerview;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            data_tv_persongal = (TextView) itemView.findViewById(R.id.data_tv_persongal);
            data_tv_age = (TextView)itemView.findViewById(R.id.data_tv_age);
            data_tv_medal = (TextView)itemView.findViewById(R.id.data_tv_medal);
            data_medal_recyclerview = (RecyclerView)itemView.findViewById(R.id.data_medal_recyclerview);
            data_tv_achevement = (TextView)itemView.findViewById(R.id.data_tv_achevement);
            data_achevement_recyclerview = (RecyclerView)itemView.findViewById(R.id.data_achevement_recyclerview);
            data_production = (TextView)itemView.findViewById(R.id.data_production);
            data_production_recyclerview = (RecyclerView)itemView.findViewById(R.id.data_production_recyclerview);

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
    DataAdapter(Context mcontext,FragmentActivity activity) {
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
    public void onBindViewHolder(DataAdapter.AdapterViewHolder holder, int position) {
        holder. data_tv_persongal.setText("个人信息");
        holder.data_tv_age.setText("乐龄");
        holder.data_tv_medal.setText("勋章");
        holder.data_medal_recyclerview.setAdapter(new MedalAdapter(mcontext,activity));
        holder.data_medal_recyclerview.setLayoutManager(new GridLayoutManager(activity,3,GridLayoutManager.VERTICAL,false));
        holder.data_tv_achevement.setText("成就");
        holder. data_achevement_recyclerview.setAdapter(new AchevementAdapter(mcontext,activity));
        holder.data_achevement_recyclerview.setLayoutManager(new GridLayoutManager(activity,3,GridLayoutManager.VERTICAL,false));
        holder.data_production.setText("K歌作品");
        holder.data_production_recyclerview.setAdapter(new ProductionAdapter(mcontext,activity));
        holder.data_production_recyclerview.setLayoutManager(new GridLayoutManager(activity,3,GridLayoutManager.VERTICAL,false));
    }





    /*
        得到总数
         */
    @Override
    public int getItemCount() {
        return 1;
    }
}
