package mefragment.meadapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.tvf.R;

import java.util.ArrayList;

import mefragment.bean.SongList;

/**
 * Created by master on 2019/7/28.
 */

public class MeAdapter extends BaseAdapter {

    private Context mcontext;
    private ArrayList<SongList> songLists;
    public MeAdapter(Context mcontext,ArrayList<SongList> songLists) {
            this.mcontext = mcontext;
        this.songLists = songLists;
    }


    @Override
    public int getCount() {
//        if(songLists!=null){
//            return songLists.size();
//        }else{
//            return 0;
//        }
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = View.inflate(mcontext.getApplicationContext(), R.layout.me_adapter_layout,null);//通过一个打气筒inflate可以把一个布局转换成一个view对象
        }
//        if(songLists.get(position)!=null){
//           SongList songList = songLists.get(position);
//            TextView tv_songlist = (TextView) convertView.findViewById(R.id.tv_songlist);
//            TextView tv_songlist_collect = (TextView) convertView.findViewById(R.id.tv_songlist_collect);
//            TextView tv_songlist_download = (TextView) convertView.findViewById(R.id.tv_songlist_download);
//            tv_songlist.setText(songList.getSonglistText());
//            tv_songlist_collect.setText(songList.getCollectCount()+"首,");
//            tv_songlist_download.setText(songList.getDownload()+"首已下载");
//        }
        ImageView iv_songlist = (ImageView) convertView.findViewById(R.id.iv_songlist);
        TextView tv_songlist = (TextView) convertView.findViewById(R.id.tv_songlist);
        TextView tv_songlist_collect = (TextView) convertView.findViewById(R.id.tv_songlist_collect);
        TextView tv_songlist_download = (TextView) convertView.findViewById(R.id.tv_songlist_download);

        iv_songlist.setImageResource(images[position]);
        tv_songlist.setText(titiles[position]);
        tv_songlist_collect.setText(collects[position]);
        tv_songlist_download.setText(downloads[position]);

        return convertView;
    }
    private  int images[] = {R.drawable.d,R.drawable.d,R.drawable.d};
    private String titiles[] = {"我喜欢","默认收藏","我的歌单2"};
    private String collects[] = {"0首","0首","0首"};
    private String downloads[] = {"0首","0首","0首"};

}

