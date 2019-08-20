package mefragment.activity.localmusicactivity.localsingerfragmnet;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.master.tvf.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import base.BaseFragment;
import mefragment.activity.localmusicactivity.localsingerfragmnet.localsingeradapter.LocalSingerAdapter;
import mefragment.activity.utils.ChineseToPinyinHelper;
import mefragment.activity.utils.PinYinView;
import mefragment.bean.SongList;
import utilsbean.User;

/**
 * Created by master on 2019/8/7.
 */

public class LocalSingerFragment extends BaseFragment{
    View rootView;
    private List<SongList> list;
    ListView local_singer_lv;
    TextView textView;
    @Override
    public View initView() {
        if(rootView==null){
            rootView = View.inflate(mContext, R.layout.local_singer_layout, null);
        }

        local_singer_lv = (ListView) rootView.findViewById(R.id.local_singer_lv);

        initData();

        final LocalSingerAdapter localSingerAdapter = new LocalSingerAdapter(mContext,list);
        local_singer_lv.setAdapter(localSingerAdapter);


        textView = (TextView)rootView.findViewById(R.id.local_singer_show_letter_in_center);
        final PinYinView pinYinView = (PinYinView) rootView.findViewById(R.id.local_singer_pinyinview);
        pinYinView.setTextViewDialot(textView);
        pinYinView.setUpdateListView(new PinYinView.UpdateListView(){

            @Override
            public void updateListview(String currentChar) {
                int positionForSection = localSingerAdapter.getPositionForSection(currentChar.charAt(0));
                local_singer_lv.setSelection(positionForSection);
            }
        });
        local_singer_lv.setOnScrollListener(new AbsListView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {


            }
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int sectionForPosition = localSingerAdapter.getSectionForPosition(firstVisibleItem);
                pinYinView.updateLetterIndexView(sectionForPosition);

            }
        });
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootView != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
    }
    @Override
    public void initData() {
        super.initData();
        list = new ArrayList<>();
        String[] allSonglistNames = {"我","你","非","真是的","我","你","非","真是的","我","你","非","真是的","我","你","非","真是的"};;
        for(String allSonglistName :allSonglistNames){
            SongList songList = new SongList();
            songList.setUsername(allSonglistName);
            String convert = ChineseToPinyinHelper.getIntence().getPinyin(allSonglistName).toUpperCase();
            songList.setPinyin(convert);
            String substring = convert.substring(0,1);
            if(substring.matches("^[A-Z]+$")){
                songList.setFirstLetter(substring);
            }else{
                songList.setFirstLetter("#");
            }
            list.add(songList);
        }
        Collections.sort(list, new Comparator<SongList>() {
            @Override
            public int compare(SongList lhs, SongList rhs) {
                if(lhs.getFirstLetter().contains("#")){
                    return 1;
                }else if(rhs.getFirstLetter().contains("#")){
                    return -1;
                }else {
                    return lhs.getFirstLetter().compareTo(rhs.getFirstLetter());
                }
            }
        });
    }
}
