package listenfragment.livefragment.adapter;

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

public class LiveGridViewAdapter extends BaseAdapter {
    private Context mcontext;



    public LiveGridViewAdapter(Context mcontext){
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
            convertView = View.inflate(mcontext, R.layout.live_item,null);
        }
        TextView title = (TextView) convertView.findViewById(R.id.live_title);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.live_imageView);
        title.setText(titles[position]);
        imageView.setImageResource(ids[position]);

        return convertView;
    }
    private String titles[] ={"乐库","歌单","电台·听书","猜你喜欢","每日推荐","更多"};
    private Integer ids[]={R.drawable.search,R.drawable.search,R.drawable.search, R.drawable.search,R.drawable.search,R.drawable.search};

}
