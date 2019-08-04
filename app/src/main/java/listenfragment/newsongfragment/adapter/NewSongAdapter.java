package listenfragment.newsongfragment.adapter;

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

public class NewSongAdapter extends BaseAdapter {
    private Context mcontext;



    public NewSongAdapter(Context mcontext){
        this.mcontext = mcontext;
    }
    @Override
    public int getCount()
    {

        return 10;

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
            convertView = View.inflate(mcontext, R.layout.newsong_listview_layout,null);
        }
        ImageView iv_newsong_add = (ImageView) convertView.findViewById(R.id.iv_newsong_add);
        ImageView iv_newsong_display = (ImageView)convertView.findViewById(R.id.iv_newsong_display);
        TextView tv_newsong_title = (TextView)convertView.findViewById(R.id.tv_newsong_title);
        TextView tv_newsong_content = (TextView)convertView.findViewById(R.id.tv_newsong_content);
        ImageView iv_newsong_message = (ImageView)convertView.findViewById(R.id.iv_newsong_message);
        TextView tv_newsong_count = (TextView)convertView.findViewById(R.id.tv_newsong_count);
        ImageView iv_newsong_more = (ImageView)convertView.findViewById(R.id.iv_newsong_more);
        TextView tv_newsong_playtime = (TextView)convertView.findViewById(R.id.tv_newsong_playtime);


        iv_newsong_add.setImageResource(R.drawable.a);
        iv_newsong_display.setImageResource(R.drawable.b);
        tv_newsong_title.setText("新歌的标题");
        tv_newsong_content.setText("新歌的内容");
        iv_newsong_message.setImageResource(R.drawable.c);
        tv_newsong_count.setText("新歌的数量");
        iv_newsong_more.setImageResource(R.drawable.d);
        tv_newsong_playtime.setText("新歌的时间");

        return convertView;
    }

}
