package listenfragment.vediofragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

/**
 * Created by master on 2019/8/2.
 */

public class VedioAdapter extends BaseAdapter {
    private Context mcontext;



    public VedioAdapter(Context mcontext){
        this.mcontext = mcontext;
    }
    @Override
    public int getCount()
    {

        return ids.length;

    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null){
            convertView = View.inflate(mcontext, R.layout.vedio_item,null);
        }
        ImageView iv_vedio_imageView = (ImageView) convertView.findViewById(R.id.iv_vedio_imageView);
        TextView tv_vedio_title = (TextView) convertView.findViewById(R.id.tv_vedio_title);
        ImageView iv_vedio_viewcount = (ImageView)convertView.findViewById(R.id.iv_vedio_viewcount);
        TextView tv_vedio_viewcount = (TextView)convertView.findViewById(R.id.tv_vedio_viewcount);
        ImageView iv_vedio_play = (ImageView)convertView.findViewById(R.id.iv_vedio_play);
        TextView tv_vedio_playcontent = (TextView)convertView.findViewById(R.id.tv_vedio_playcontent);


        iv_vedio_imageView.setImageResource(ids[position]);
        tv_vedio_title.setText(titles[position]);
        iv_vedio_viewcount.setImageResource(ids[position]);
        tv_vedio_viewcount.setText(titles[position]);
        iv_vedio_play.setImageResource(ids[position]);
        tv_vedio_playcontent.setText(titles[position]);

        return convertView;
    }

    private String titles[] ={"乐库","歌单","电台·听书","猜你喜欢","每日推荐","更多"};
    private Integer ids[]={R.drawable.search,R.drawable.search,R.drawable.search, R.drawable.search,R.drawable.search,R.drawable.search};



}
