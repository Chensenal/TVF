package mefragment.activity.localmusicactivity.singlefragment.singleadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.master.tvf.R;

import java.util.List;

import mefragment.bean.SongList;
import utilsbean.User;

/**
 * Created by master on 2019/8/7.
 */

public class SingleAdapter  extends BaseAdapter implements SectionIndexer {



    private List<SongList>list;
    private Context context;
    private LayoutInflater inflater;
    public  SingleAdapter(Context context,List<SongList>list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int potision) {
        return potision;
    }

    @Override
    public View getView(int potision, View covertview, ViewGroup parent) {
        ViewHolder holder;
        if(covertview==null){
            covertview = inflater.inflate(R.layout.single_item,null);
            holder = new ViewHolder();
            holder.single_tv_title = (TextView) covertview.findViewById(R.id.single_tv_title);
            covertview.setTag(holder);
        }else{
            holder = (ViewHolder)covertview.getTag();
        }
        SongList songList = list.get(potision);
        holder.single_tv_title.setText(songList.getUsername());
        return covertview;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionindex) {
        if(list!=null&&list.size()>0){
            for (int i = 0;i <list.size();i++){
                if(list.get(i).getFirstLetter().charAt(0)==sectionindex){
                    return  i;
                }
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int position) {
        if(list!=null&&list.size()>0){
            return list.get(position).getFirstLetter().charAt(0);
        }
        return 0;
    }

    class ViewHolder{
        ImageView single_iv_add;
        TextView single_tv_title;
        TextView singl_tv_content;
        ImageView single_iv_collect;
        ImageView single_iv_more;

    }
}
