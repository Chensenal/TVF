package listenfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

/**
 * Created by master on 2019/7/28.
 */

public class ListenGradViewAdapter extends BaseAdapter {
    private Context mcontext;



    public ListenGradViewAdapter(Context mcontext){
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
            convertView = View.inflate(mcontext, R.layout.listen_item,null);
        }
        TextView title = (TextView) convertView.findViewById(R.id.listen_title);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.listen_image);
        title.setText(titles[position]);
        imageView.setImageResource(ids[position]);

        return convertView;
    }
    private String titles[] ={"乐库","歌单","电台·听书","猜你喜欢","每日推荐","更多"};
    private Integer ids[]={R.drawable.search,R.drawable.search,R.drawable.search, R.drawable.search,R.drawable.search,R.drawable.search};

}
