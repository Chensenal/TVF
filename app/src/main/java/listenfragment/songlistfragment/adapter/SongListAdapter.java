package listenfragment.songlistfragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

/**
 * Created by master on 2019/8/3.
 */

public class SongListAdapter extends BaseAdapter {
    private Context mcontext;



    public SongListAdapter(Context mcontext){
        this.mcontext = mcontext;
    }
    @Override
    public int getCount()
    {

        return 3;

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
            convertView = View.inflate(mcontext, R.layout.listen_songlist_listview_layout,null);
        }
        ImageView iviv_listen_songlist_display = (ImageView)convertView.findViewById(R.id.iv_listen_songlist_display);
        TextView tv_listen_songlist_title = (TextView)convertView.findViewById(R.id.tv_listen_songlist_title);
        TextView tv_listen_songlist_content1 = (TextView)convertView.findViewById(R.id.tv_listen_songlist_content1);
        TextView tv_listen_songlist_content2 = (TextView)convertView.findViewById(R.id.tv_listen_songlist_content2);
        TextView tv_listen_songlist_content3 = (TextView)convertView.findViewById(R.id.tv_listen_songlist_content3);

        iviv_listen_songlist_display.setImageResource(songlistimages[position]);
        tv_listen_songlist_title.setText(songlisttitles[position]);
        tv_listen_songlist_content1.setText(content1s[position]);
        tv_listen_songlist_content2.setText(content2s[position]);
        tv_listen_songlist_content3.setText(content3s[position]);

        return convertView;
    }
    private int songlistimages[] = {R.drawable.a,R.drawable.b,R.drawable.c};
    private String songlisttitles[] = {"标题1","标题2","标题3"};
    private  String content1s[] = {"内容11","内容12","内容13"};
    private  String content2s[] = {"内容21","内容22","内容23"};
    private  String content3s[] = {"内容31","内容32","内容33"};
}
